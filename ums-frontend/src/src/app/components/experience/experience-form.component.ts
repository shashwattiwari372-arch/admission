import { ChangeDetectorRef, Component, OnInit, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { finalize } from 'rxjs';
import { CandidateExpService } from '../../services/candidate-exp.service';
import { CandidateExp } from '../../models/candidate-exp.model';

@Component({
  selector: 'app-experience-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './experience-form.component.html',   // your existing form HTML, unchanged
  styleUrl: './experience-shared.css'
})
export class ExperienceFormComponent implements OnInit {
  private fb = inject(FormBuilder);
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private service = inject(CandidateExpService);
  private cdr = inject(ChangeDetectorRef);

  orgTypes = ['Government', 'Public sector', 'Private', 'NGO', 'Academic', 'Other'];
  jobTypes = ['Permanent', 'Contract', 'Temporary', 'Part-time', 'Internship'];

  isEdit = false;
  id: number | null = null;
  loading = false;
  saving = false;
  submitted = false;
  errorMessage = '';
  successMessage = '';

  form = this.fb.group({
    appId: [null as number | null, Validators.required],
    employerName: ['', Validators.required],
    orgType: [''],
    orgWebsite: [''],
    orgMobile: ['', Validators.pattern(/^[0-9+\-\s]*$/)],
    orgEmail: ['', Validators.email],
    designation: ['', Validators.required],
    jobType: [''],
    fromDt: ['', Validators.required],
    toDt: [''],
    payLevel: [''],
    lastPay: [''],
    basicPay: [null as number | null, Validators.min(0)],
    otherAllowance: [null as number | null, Validators.min(0)],
    natureWork: [''],
    responsibilities: [''],
    reasonLeave: [''],
    remark: ['']
  });

  get total(): number {
    const v = this.form.value;
    return (Number(v.basicPay) || 0) + (Number(v.otherAllowance) || 0);
  }

  invalid(name: string): boolean {
    const c = this.form.get(name);
    return !!c && c.invalid && (c.touched || c.dirty || this.submitted);
  }

  ngOnInit() {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (!idParam) return;

    this.isEdit = true;
    this.id = Number(idParam);
    this.loading = true;
    this.service.getById(this.id)
      .pipe(finalize(() => { this.loading = false; this.cdr.markForCheck(); }))
      .subscribe({
        next: exp => this.form.patchValue({
          ...exp,
          fromDt: exp.fromDt?.slice(0, 10),
          toDt: exp.toDt ? exp.toDt.slice(0, 10) : ''
        } as any),
        error: () => {
          this.errorMessage = 'Could not load this record. Go back to the list and try again.';
        }
      });
  }

  submit() {
    this.submitted = true;
    this.errorMessage = '';
    this.successMessage = '';

    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.errorMessage = 'Fix the highlighted fields and save again.';
      return;
    }

    const v = this.form.getRawValue();
    if (v.toDt && v.fromDt && v.toDt < v.fromDt) {
      this.errorMessage = '“To date” cannot be earlier than “From date”.';
      return;
    }

    // empty strings → null so the backend does not store ''
    const clean = (s: string | null) => (s && s.trim() ? s.trim() : null);
    const payload: CandidateExp = {
      appId: Number(v.appId),
      employerName: v.employerName!.trim(),
      orgType: clean(v.orgType),
      orgWebsite: clean(v.orgWebsite),
      orgMobile: clean(v.orgMobile),
      orgEmail: clean(v.orgEmail),
      designation: v.designation!.trim(),
      jobType: clean(v.jobType),
      fromDt: v.fromDt!,
      toDt: v.toDt || null,
      payLevel: clean(v.payLevel),
      lastPay: clean(v.lastPay),
      basicPay: v.basicPay != null ? Number(v.basicPay) : null,
      otherAllowance: v.otherAllowance != null ? Number(v.otherAllowance) : null,
      totalEmoluments: this.total,
      natureWork: clean(v.natureWork),
      responsibilities: clean(v.responsibilities),
      reasonLeave: clean(v.reasonLeave),
      remark: clean(v.remark)
    };

    this.saving = true;
    const request$ = this.isEdit && this.id != null
      ? this.service.update(this.id, payload)
      : this.service.create(payload);

    request$
      .pipe(finalize(() => { this.saving = false; this.cdr.markForCheck(); }))
      .subscribe({
        next: () => {
          this.successMessage = this.isEdit ? 'Changes saved.' : 'Experience saved.';
          this.cdr.markForCheck();
          setTimeout(() => this.goBack(), 900);
        },
        error: err => {
          console.error('Save failed', err);
          this.errorMessage =
            err.status === 400 ? 'The server rejected some values. Check the fields and try again.'
            : err.status === 0 ? 'Cannot reach the server.'
            : 'Could not save the record. Check the backend console for details.';
          this.cdr.markForCheck();
        }
      });
  }

  goBack() { this.router.navigate(['/experience']); }
}
