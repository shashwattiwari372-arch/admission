import { Component, OnInit, inject } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CandidateExp } from '../candidate-exp.model';
import { CandidateExpService } from '../candidate-exp.service';

@Component({
  selector: 'app-candidate-exp-form',
  imports: [ReactiveFormsModule],
  templateUrl: './candidate-exp-form.html',
  styleUrl: './candidate-exp-form.css',
})
export class CandidateExpForm implements OnInit {
  private fb = inject(FormBuilder);
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private api = inject(CandidateExpService);

  id: number | null = null;
  loading = false;
  saving = false;
  errorMessage = '';
  successMessage = '';

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

  get isEdit(): boolean {
    return this.id !== null;
  }

  get total(): number {
    const v = this.form.value;
    return (Number(v.basicPay) || 0) + (Number(v.otherAllowance) || 0);
  }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    const appId = this.route.snapshot.queryParamMap.get('appId');
    if (appId) this.form.patchValue({ appId: Number(appId) });

    if (idParam) {
      this.id = Number(idParam);
      this.loading = true;
      this.api.getById(this.id).subscribe({
        next: (data) => {
          this.form.patchValue(data as any);
          this.loading = false;
        },
        error: () => {
          this.errorMessage = 'Could not load this experience record.';
          this.loading = false;
        },
      });
    }
  }

  invalid(name: string): boolean {
    const c = this.form.get(name);
    return !!c && c.invalid && (c.touched || c.dirty);
  }

  submit(): void {
    this.errorMessage = '';
    this.successMessage = '';
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.errorMessage = 'Please fill in all required fields correctly.';
      return;
    }

    // empty strings -> null so the backend can parse dates / numbers
    const raw = this.form.getRawValue() as Record<string, unknown>;
    const payload = Object.fromEntries(
      Object.entries(raw).map(([k, v]) => [k, v === '' ? null : v]),
    ) as unknown as CandidateExp;

    this.saving = true;
    const request = this.isEdit ? this.api.update(this.id!, payload) : this.api.create(payload);
    request.subscribe({
      next: () => {
        this.saving = false;
        this.successMessage = this.isEdit ? 'Experience updated.' : 'Experience saved.';
        setTimeout(() => this.goBack(), 800);
      },
      error: (err: HttpErrorResponse) => {
        this.saving = false;
        this.errorMessage = err.error?.message ?? 'Could not save the experience. Try again.';
      },
    });
  }

  goBack(): void {
    const appId = this.form.value.appId;
    this.router.navigate(['/ums/candidate-exp'], appId ? { queryParams: { appId } } : {});
  }
}
