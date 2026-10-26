import { Component, OnInit, computed, inject, signal } from '@angular/core';
import { formatDate } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { finalize } from 'rxjs';
import { TableApiService } from '../../../core/services/table-api.service';
import { ToastService } from '../../../core/services/toast.service';
import { ConfirmDialog } from '../../../shared/confirm-dialog/confirm-dialog';
import { FieldDef, Row, TableDef } from '../table.models';
import { findTable } from '../tables.config';

const PAGE_SIZE = 15;

@Component({
  selector: 'app-table-list',
  imports: [RouterLink, ConfirmDialog],
  templateUrl: './table-list.html',
  styles: `
    .clip { display: block; max-width: 280px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; }
    .pager { display: flex; align-items: center; justify-content: flex-end; gap: 12px; padding: 12px 18px; border-top: 1px solid var(--line); }
    .muted { color: var(--muted); }
    .chip { display: inline-flex; align-items: center; gap: 6px; }
  `,
})
export class TableList implements OnInit {
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private api = inject(TableApiService);
  private toast = inject(ToastService);

  def = signal<TableDef | null>(null);
  notFound = signal(false);
  items = signal<Row[]>([]);
  loading = signal(true);
  error = signal('');
  query = signal('');
  page = signal(1);
  /** optional ?appId=5 style filter coming from other pages */
  filterField = signal('');
  filterValue = signal('');
  toDelete = signal<Row | null>(null);
  deleting = signal(false);

  columns = computed<FieldDef[]>(() => {
    const d = this.def();
    if (!d) return [];
    return d.columns.map((c) => d.fields.find((f) => f.name === c)).filter((f): f is FieldDef => !!f);
  });

  filtered = computed(() => {
    const d = this.def();
    if (!d) return [];
    const q = this.query().trim().toLowerCase();
    const ff = this.filterField();
    const fv = this.filterValue();
    const searchable = d.fields.filter((f) => !f.secret && f.section !== 'audit');
    return this.items().filter((r) => {
      if (ff && String(r[ff] ?? '') !== fv) return false;
      if (!q) return true;
      if (String(r[d.idField] ?? '') === q) return true;
      return searchable.some((f) => String(r[f.name] ?? '').toLowerCase().includes(q));
    });
  });

  pageCount = computed(() => Math.max(1, Math.ceil(this.filtered().length / PAGE_SIZE)));
  currentPage = computed(() => Math.min(this.page(), this.pageCount()));
  pageItems = computed(() => {
    const p = this.currentPage();
    return this.filtered().slice((p - 1) * PAGE_SIZE, p * PAGE_SIZE);
  });

  ngOnInit(): void {
    this.route.paramMap.subscribe((pm) => {
      const d = findTable(pm.get('table'));
      this.items.set([]);
      this.query.set('');
      this.page.set(1);
      if (!d) { this.def.set(null); this.notFound.set(true); this.loading.set(false); return; }
      if (d.link) { this.router.navigateByUrl(d.link, { replaceUrl: true }); return; }
      this.notFound.set(false);
      this.def.set(d);
      const qp = this.route.snapshot.queryParamMap;
      const hit = d.fields.find((f) => qp.has(f.name));
      this.filterField.set(hit ? hit.name : '');
      this.filterValue.set(hit ? (qp.get(hit.name) ?? '') : '');
      this.load();
    });
  }

  load(): void {
    const d = this.def();
    if (!d) return;
    this.loading.set(true);
    this.error.set('');
    this.api.getAll(d)
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (data) => this.items.set(Array.isArray(data) ? data : []),
        error: (err) => this.error.set(
          err.status === 0 ? 'Cannot reach the server. Check that the backend is running on port 8080.'
          : `Could not load ${d.label.toLowerCase()}.`
        ),
      });
  }

  onSearch(ev: Event): void {
    this.query.set((ev.target as HTMLInputElement).value);
    this.page.set(1);
  }

  rowId(row: Row): unknown { return row[this.def()?.idField ?? 'id']; }

  clearFilter(): void { this.filterField.set(''); this.filterValue.set(''); this.page.set(1); }

  prev(): void { this.page.set(Math.max(1, this.currentPage() - 1)); }
  next(): void { this.page.set(Math.min(this.pageCount(), this.currentPage() + 1)); }

  /** Text shown in a table cell. */
  show(row: Row, f: FieldDef): string {
    const v = row[f.name];
    if (v === null || v === undefined || v === '') return '—';
    if (f.secret) return '••••••';
    if (f.type === 'date') {
      try { return formatDate(v, 'dd MMM yyyy', 'en-US'); } catch { return String(v); }
    }
    if (f.type === 'time') return String(v).slice(0, 8);
    return String(v);
  }

  rowName(row: Row): string {
    const d = this.def();
    if (!d) return 'this record';
    const first = d.columns.map((c) => row[c]).find((v) => v !== null && v !== undefined && v !== '');
    return first !== undefined ? String(first) : `#${row[d.idField]}`;
  }

  confirmDelete(): void {
    const d = this.def();
    const target = this.toDelete();
    if (!d || !target) return;
    const id = target[d.idField];
    this.deleting.set(true);
    this.api.remove(d, id)
      .pipe(finalize(() => this.deleting.set(false)))
      .subscribe({
        next: () => {
          this.items.update((l) => l.filter((x) => x[d.idField] !== id));
          this.toDelete.set(null);
          this.toast.success(`Deleted ${d.singular} “${this.rowName(target)}”.`);
        },
        error: (err) => {
          this.toDelete.set(null);
          this.toast.error(err.error?.message ?? `Could not delete this ${d.singular}.`);
        },
      });
  }
}
