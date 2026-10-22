import { Component, OnInit, inject, signal } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormControl, FormGroup, ReactiveFormsModule, ValidatorFn, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { finalize } from 'rxjs';
import { CandidateProfile } from '../../../core/models/candidate-profile.model';
import { State } from '../../../core/models/state.model';
import { CandidateProfileService } from '../../../core/services/candidate-profile.service';
import { StateService } from '../../../core/services/state.service';
import { ToastService } from '../../../core/services/toast.service';

type FieldType = 'text' | 'email' | 'tel' | 'number' | 'date' | 'select' | 'textarea' | 'state';

interface FieldDef {
  key: keyof CandidateProfile & string;
  label: string;
  type?: FieldType;
  required?: boolean;
  options?: string[];
  wide?: boolean;
  pattern?: RegExp;
  patternMsg?: string;
  hint?: string;
}
interface Section { title: string; sub?: string; fields: FieldDef[]; }

const MOBILE = /^[0-9+\-\s]{7,15}$/;

@Component({
  selector: 'app-candidate-form',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './candidate-form.html',
})
export class CandidateForm implements OnInit {
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private api = inject(CandidateProfileService);
  private stateApi = inject(StateService);
  private toast = inject(ToastService);

  id: number | null = null;
  loading = signal(false);
  saving = signal(false);
  error = signal('');
  states = signal<State[]>([]);
  private original: CandidateProfile | null = null;

  /** Everything the form shows lives in this list — add a field here and it appears automatically. */
  sections: Section[] = [
    {
      title: 'Personal details',
      sub: 'Basic information about the candidate.',
      fields: [
        { key: 'title', label: 'Title', type: 'select', options: ['Mr.', 'Ms.', 'Mrs.', 'Dr.', 'Prof.'] },
        { key: 'fullName', label: 'Full name', required: true },
        { key: 'email', label: 'Email', type: 'email', required: true },
        { key: 'alternativeEmail', label: 'Alternative email', type: 'email' },
        { key: 'mobileNo', label: 'Mobile number', type: 'tel', pattern: MOBILE, patternMsg: 'Use 7–15 digits (+, - and spaces allowed).' },
        { key: 'gender', label: 'Gender', type: 'select', options: ['Male', 'Female', 'Other'] },
        { key: 'dob', label: 'Date of birth', type: 'date' },
        { key: 'maritalStatus', label: 'Marital status', type: 'select', options: ['Single', 'Married', 'Divorced', 'Widowed'] },
        { key: 'bloodGroup', label: 'Blood group', type: 'select', options: ['A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-'] },
        { key: 'category', label: 'Category', type: 'select', options: ['General', 'EWS', 'OBC', 'SC', 'ST'] },
        { key: 'nationality', label: 'Nationality' },
        { key: 'religion', label: 'Religion' },
        { key: 'physicallyChallenged', label: 'Physically challenged', type: 'select', options: ['No', 'Yes'] },
      ],
    },
    {
      title: 'Family',
      sub: 'Parents and household details.',
      fields: [
        { key: 'fatherHusbandName', label: 'Father / husband name' },
        { key: 'motherName', label: 'Mother name' },
        { key: 'fatherMobile', label: 'Father mobile', type: 'tel', pattern: MOBILE, patternMsg: 'Use 7–15 digits.' },
        { key: 'motherMobile', label: 'Mother mobile', type: 'tel', pattern: MOBILE, patternMsg: 'Use 7–15 digits.' },
        { key: 'fatherOccupation', label: 'Father occupation' },
        { key: 'motherOccupation', label: 'Mother occupation' },
        { key: 'siblings', label: 'Siblings', type: 'number' },
        { key: 'annualIncome', label: 'Annual family income' },
      ],
    },
    {
      title: 'Current organisation',
      sub: 'Where the candidate works now, if applicable.',
      fields: [
        { key: 'orgName', label: 'Organisation name' },
        { key: 'designation', label: 'Designation' },
        { key: 'orgPhone', label: 'Organisation phone', type: 'tel' },
        { key: 'orgEmail', label: 'Organisation email', type: 'email' },
        { key: 'orgWebsite', label: 'Website' },
        { key: 'city', label: 'City' },
        { key: 'distt', label: 'District' },
        { key: 'state', label: 'State', type: 'state' },
      ],
    },
    {
      title: 'Identity documents',
      sub: 'Leave blank anything that does not apply.',
      fields: [
        { key: 'aadhaarNo', label: 'Aadhaar number', pattern: /^\d{12}$/, patternMsg: 'Aadhaar has 12 digits.' },
        { key: 'apaarId', label: 'APAAR ID' },
        { key: 'panNo', label: 'PAN', pattern: /^[A-Za-z]{5}\d{4}[A-Za-z]$/, patternMsg: 'Format: ABCDE1234F.' },
        { key: 'voterId', label: 'Voter ID' },
        { key: 'passportNo', label: 'Passport number' },
        { key: 'drivingLicenseNo', label: 'Driving licence number' },
      ],
    },
    {
      title: 'Address and notes',
      fields: [
        { key: 'localAddress', label: 'Local address', type: 'textarea', wide: true },
        { key: 'permanentAddress', label: 'Permanent address', type: 'textarea', wide: true },
        { key: 'remark', label: 'Remark', type: 'textarea', wide: true },
      ],
    },
  ];

  private allFields = this.sections.flatMap((s) => s.fields);
  form = new FormGroup<Record<string, FormControl<string>>>({});

  constructor() {
    for (const f of this.allFields) {
      const v: ValidatorFn[] = [];
      if (f.required) v.push(Validators.required);
      if (f.type === 'email') v.push(Validators.email);
      if (f.pattern) v.push(Validators.pattern(f.pattern));
      if (f.type === 'number') v.push(Validators.min(0));
      this.form.addControl(f.key, new FormControl('', { nonNullable: true, validators: v }));
    }
  }

  get isEdit(): boolean { return this.id !== null; }

  ngOnInit(): void {
    this.stateApi.getAllStates().subscribe({
      next: (s) => this.states.set(Array.isArray(s) ? s : []),
      error: () => this.states.set([]), // falls back to a plain text box
    });

    const idParam = this.route.snapshot.paramMap.get('id');
    if (!idParam) return;
    this.id = Number(idParam);
    this.loading.set(true);
    this.api.getCandidateById(this.id)
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (c) => {
          this.original = c;
          const values: Record<string, string> = {};
          for (const f of this.allFields) {
            const raw = c[f.key];
            let s = raw === null || raw === undefined ? '' : String(raw);
            if (f.type === 'date') s = s.slice(0, 10);
            values[f.key] = s;
          }
          this.form.patchValue(values);
        },
        error: () => this.error.set('Could not load this candidate. Go back to the list and try again.'),
      });
  }

  invalid(key: string): boolean {
    const c = this.form.get(key);
    return !!c && c.invalid && (c.touched || c.dirty);
  }

  errorText(f: FieldDef): string {
    const e = this.form.get(f.key)?.errors;
    if (!e) return '';
    if (e['required']) return `${f.label} is required.`;
    if (e['email']) return 'Enter a valid email address.';
    if (e['pattern']) return f.patternMsg ?? 'Invalid format.';
    if (e['min']) return 'Cannot be negative.';
    return 'Invalid value.';
  }

  submit(): void {
    this.error.set('');
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.error.set('Fix the highlighted fields and save again.');
      return;
    }
    const raw = this.form.getRawValue();
    const out: Record<string, unknown> = {};
    for (const f of this.allFields) {
      const v = (raw[f.key] ?? '').trim();
      out[f.key] = v === '' ? null : f.type === 'number' ? Number(v) : v;
    }
    // keep fields that are not on this form (verification flags, audit columns…) untouched
    const payload = { ...(this.original ?? {}), ...out } as unknown as CandidateProfile;

    this.saving.set(true);
    const req = this.isEdit ? this.api.updateCandidate(this.id!, payload) : this.api.createCandidate(payload);
    req.pipe(finalize(() => this.saving.set(false))).subscribe({
      next: () => {
        this.toast.success(this.isEdit ? 'Candidate updated.' : 'Candidate added.');
        this.router.navigate(['/candidates']);
      },
      error: (err: HttpErrorResponse) => {
        this.error.set(
          err.status === 0 ? 'Cannot reach the server.'
          : err.status === 409 ? 'A candidate with this email already exists.'
          : err.error?.message ?? 'Could not save the candidate. Check the details and try again.'
        );
      },
    });
  }
}
