import { NgTemplateOutlet } from '@angular/common';
import { Component, OnInit, computed, inject, signal } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { AbstractControl, FormControl, FormGroup, ReactiveFormsModule, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { finalize } from 'rxjs';
import { TableApiService } from '../../../core/services/table-api.service';
import { ToastService } from '../../../core/services/toast.service';
import { FieldDef, FieldSection, Row, TableDef } from '../table.models';
import { findTable } from '../tables.config';

/** Required that also rejects text made only of spaces. */
const requiredText: ValidatorFn = (c: AbstractControl): ValidationErrors | null => {
  const v = c.value;
  return v === null || v === undefined || String(v).trim() === '' ? { required: true } : null;
};

@Component({
  selector: 'app-table-form',
  imports: [ReactiveFormsModule, RouterLink, NgTemplateOutlet],
  templateUrl: './table-form.html',
  styles: `
    details { margin-top: 18px; }
    details > summary { cursor: pointer; font-weight: 700; font-size: 15px; list-style: none; display: flex; align-items: center; gap: 8px; padding-bottom: 14px; }
    details > summary::before { content: '▸'; transition: transform .15s; color: var(--muted); }
    details[open] > summary::before { transform: rotate(90deg); }
    details > summary small { font-weight: 500; color: var(--muted); }
    .meta { color: var(--muted); font-size: 13px; margin-bottom: 14px; }
  `,
})
export class TableForm implements OnInit {
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private api = inject(TableApiService);
  private toast = inject(ToastService);

  def = signal<TableDef | null>(null);
  notFound = signal(false);
  id: string | null = null;
  loading = signal(false);
  saving = signal(false);
  error = signal('');
  form = new FormGroup<Record<string, FormControl>>({});
  /** the record as loaded, so hidden columns (audit / verification) are sent back unchanged */
  private original: Row | null = null;
  record = signal<Row | null>(null);

  get isEdit(): boolean { return this.id !== null; }

  mainFields = computed(() => this.bySection('main'));
  statusFields = computed(() => this.bySection('status'));
  extraFields = computed(() => this.bySection('extra'));
  openStatus = computed(() => this.mainFields().length < 5);

  lastUpdate = computed(() => {
    const r = this.record();
    if (!r || !r['updateBy']) return '';
    const when = [r['updateDt'], r['updateTime'] ? String(r['updateTime']).slice(0, 8) : ''].filter(Boolean).join(' ');
    return `Last updated by ${r['updateBy']}${when ? ' on ' + when : ''}.`;
  });

  ngOnInit(): void {
    this.route.paramMap.subscribe((pm) => {
      const d = findTable(pm.get('table'));
      this.error.set('');
      if (!d || d.link) { this.notFound.set(true); this.def.set(null); return; }
      this.notFound.set(false);
      this.def.set(d);
      this.buildForm(d);
      this.id = pm.get('id');
      if (this.id !== null) this.loadRecord(d, this.id);
    });
  }

  private bySection(s: FieldSection): FieldDef[] {
    return this.def()?.fields.filter((f) => f.section === s) ?? [];
  }

  private buildForm(d: TableDef): void {
    const group = new FormGroup<Record<string, FormControl>>({});
    for (const f of d.fields) {
      if (f.section === 'audit') continue;
      const v: ValidatorFn[] = [];
      if (f.required) v.push(requiredText);
      if (f.type === 'text' || f.type === 'textarea') { if (f.max) v.push(Validators.maxLength(f.max)); }
      if (f.type === 'number') {
        if (f.min !== undefined) v.push(Validators.min(f.min));
        if (f.max !== undefined) v.push(Validators.max(f.max));
      }
      group.addControl(f.name, new FormControl(f.type === 'number' || f.type === 'decimal' ? null : '', v));
    }
    this.form = group;
    this.original = null;
    this.record.set(null);
  }

  private loadRecord(d: TableDef, id: string): void {
    this.loading.set(true);
    this.api.getOne(d, id)
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (row) => {
          this.original = row;
          this.record.set(row);
          const patch: Row = {};
          for (const f of d.fields) {
            if (f.section === 'audit') continue;
            const v = row[f.name];
            if (f.type === 'date') patch[f.name] = v ? String(v).slice(0, 10) : '';
            else if (f.type === 'time') patch[f.name] = v ? String(v).slice(0, 8) : '';
            else if (f.type === 'number' || f.type === 'decimal') patch[f.name] = v ?? null;
            else patch[f.name] = v ?? '';
          }
          this.form.patchValue(patch);
        },
        error: () => this.error.set('Could not load this record. Go back to the list and try again.'),
      });
  }

  invalid(name: string): boolean {
    const c = this.form.controls[name];
    return !!c && c.invalid && (c.touched || c.dirty);
  }

  message(f: FieldDef): string {
    const c = this.form.controls[f.name];
    if (c.hasError('required')) return `${f.label} is required.`;
    if (c.hasError('maxlength')) return `${f.label} can be at most ${f.max} characters.`;
    if (c.hasError('min') || c.hasError('max')) return `${f.label} must be between ${f.min} and ${f.max}.`;
    return 'Enter a valid value.';
  }

  inputType(f: FieldDef): string {
    if (f.secret) return 'password';
    return f.type === 'number' || f.type === 'decimal' ? 'number' : f.type;
  }

  submit(): void {
    const d = this.def();
    if (!d) return;
    this.error.set('');
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.error.set('Fix the highlighted fields and save again.');
      return;
    }
    const raw = this.form.getRawValue();
    const payload: Row = { ...(this.original ?? {}) };
    for (const f of d.fields) {
      if (f.section === 'audit') continue;
      let v: any = raw[f.name];
      if (typeof v === 'string') { v = v.trim(); if (v === '') v = null; }
      if (v !== null && (f.type === 'number' || f.type === 'decimal')) v = Number(v);
      payload[f.name] = v;
    }

    this.saving.set(true);
    const req = this.isEdit ? this.api.update(d, this.id!, payload) : this.api.create(d, payload);
    req.pipe(finalize(() => this.saving.set(false))).subscribe({
      next: () => {
        this.toast.success(this.isEdit ? `${this.cap(d.singular)} updated.` : `${this.cap(d.singular)} added.`);
        this.router.navigate(['/tables', d.key]);
      },
      error: (err: HttpErrorResponse) => {
        this.error.set(
          err.status === 0 ? 'Cannot reach the server.'
          : err.error?.message ?? `Could not save the ${d.singular}. Check the details and try again.`
        );
      },
    });
  }

  cap(s: string): string { return s.charAt(0).toUpperCase() + s.slice(1); }
}
