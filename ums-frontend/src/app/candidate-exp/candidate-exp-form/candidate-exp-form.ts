import { Component, OnInit, inject, signal } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { finalize } from 'rxjs';
import { CandidateExp } from '../candidate-exp.model';
import { CandidateExpService } from '../candidate-exp.service';
import { ToastService } from '../../core/services/toast.service';

@Component({
  selector: 'app-candidate-exp-form',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './candidate-exp-form.html',
})
export class CandidateExpForm implements OnInit {
  private fb = inject(FormBuilder);
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private api = inject(CandidateExpService);
  private toast = inject(ToastService);

  id: number | null = null;
  loading = signal(false);
  saving = signal(false);
  error = signal('');

  orgTypes = ['Government', 'Public Sector', 'Private', 'Semi-Government', 'Autonomous Body', 'NGO', 'Other'];
  jobTypes = ['Permanent', 'Contractual', 'Temporary', 'Deputation', 'Part-time'];

  form = this.fb.group({
    appId: [null as number | null, [Validators.required, Validators.min(1)]],
    employerName: ['', [Validators.required, Validators.maxLength(150)]],
    orgType: [''],
    orgWebsite: ['', Validators.maxLength(255)],
    orgMobile: ['', [Validators.maxLength(15), Validators.pattern(/^[0-9+\-\s]*$/)]],
    orgEmail: ['', [Validators.email, Validators.maxLength(100)]],
    fromDt: ['', Validators.required],
    toDt: [''],
    designation: ['', [Validators.required, Validators.maxLength(100)]],
    jobType: [''],
    payLevel: ['', Validators.maxLength(45)],
    lastPay: ['', Validators.maxLength(45)],
    basicPay: [null as number | null, Validators.min(0)],
    otherAllowance: [null as number | null, Validators.min(0)],
    natureWork: ['', Validators.maxLength(500)],
    responsibilities: [''],
    reasonLeave: ['', Validators.maxLength(500)],
    remark: ['', Validators.maxLength(45)],
  });

  get isEdit(): boolean { return this.id !== null; }

  get total(): number {
    const v = this.form.value;
    return (Number(v.basicPay) || 0) + (Number(v.otherAllowance) || 0);
  }

  /** Back-link target: keeps the application filter if we came from one. */
  get backQuery(): Record<string, number> {
    const a = this.form.value.appId;
    return a ? { appId: a } : {};
  }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    const appId = this.route.snapshot.queryParamMap.get('appId');
    if (appId && !isNaN(Number(appId))) this.form.patchValue({ appId: Number(appId) });

    if (!idParam) return;
    this.id = Number(idParam);
    this.loading.set(true);
    this.api.getById(this.id)
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (d) => this.form.patchValue({
          ...d,
          fromDt: d.fromDt?.slice(0, 10) ?? '',
          toDt: d.toDt ? d.toDt.slice(0, 10) : '',
        } as any),
        error: () => this.error.set('Could not load this record. Go back to the list and try again.'),
      });
  }

  invalid(name: string): boolean {
    const c = this.form.get(name);
    return !!c && c.invalid && (c.touched || c.dirty);
  }

  submit(): void {
    this.error.set('');
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.error.set('Fix the highlighted fields and save again.');
      return;
    }
    const v = this.form.getRawValue();
    if (v.toDt && v.fromDt && v.toDt < v.fromDt) {
      this.error.set('“To date” cannot be earlier than “From date”.');
      return;
    }

    // empty strings become null so the backend can parse dates and numbers
    const clean = (s: string | null) => (s && s.trim() ? s.trim() : null);
    const payload: CandidateExp = {
      appId: Number(v.appId),
      employerName: v.employerName!.trim(),
      orgType: clean(v.orgType),
      orgWebsite: clean(v.orgWebsite),
      orgMobile: clean(v.orgMobile),
      orgEmail: clean(v.orgEmail),
      fromDt: v.fromDt!,
      toDt: v.toDt || null,
      designation: v.designation!.trim(),
      jobType: clean(v.jobType),
      payLevel: clean(v.payLevel),
      lastPay: clean(v.lastPay),
      basicPay: v.basicPay != null ? Number(v.basicPay) : null,
      otherAllowance: v.otherAllowance != null ? Number(v.otherAllowance) : null,
      totalEmoluments: this.total,
      natureWork: clean(v.natureWork),
      responsibilities: clean(v.responsibilities),
      reasonLeave: clean(v.reasonLeave),
      remark: clean(v.remark),
    };

    this.saving.set(true);
    const req = this.isEdit ? this.api.update(this.id!, payload) : this.api.create(payload);
    req.pipe(finalize(() => this.saving.set(false))).subscribe({
      next: () => {
        this.toast.success(this.isEdit ? 'Experience updated.' : 'Experience saved.');
        this.router.navigate(['/experience'], { queryParams: this.backQuery });
      },
      error: (err: HttpErrorResponse) => {
        this.error.set(
          err.status === 0 ? 'Cannot reach the server.'
          : err.status === 400 ? err.error?.message ?? 'The server rejected some values. Check the fields and try again.'
          : err.error?.message ?? 'Could not save the experience. Try again.'
        );
      },
    });
  }
}
