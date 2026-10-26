import { ChangeDetectorRef, Component, OnInit, inject, signal } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { finalize } from 'rxjs';
import { Employee } from '../../../core/models/employee.model';
import { EmployeeService } from '../../../core/services/employee.service';
import { ToastService } from '../../../core/services/toast.service';

@Component({
  selector: 'app-employee-form',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './employee-form.html',
})
export class EmployeeForm implements OnInit {
  private fb = inject(FormBuilder);
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private api = inject(EmployeeService);
  private toast = inject(ToastService);

  id: number | null = null;
  loading = signal(false);
  saving = signal(false);
  error = signal('');

  departments = ['Engineering', 'Human Resources', 'Finance', 'Operations', 'Sales', 'Marketing', 'Administration', 'IT Support'];
  employmentTypes = ['Full-time', 'Part-time', 'Contract', 'Intern'];

  form = this.fb.nonNullable.group({
    fullName: ['', [Validators.required, Validators.maxLength(100)]],
    email: ['', [Validators.required, Validators.email]],
    password: [''],
    age: [null as number | null, [Validators.required, Validators.min(18), Validators.max(70)]],
    gender: ['', Validators.required],
    department: ['', Validators.required],
    employmentType: ['', Validators.required],
    joiningDate: ['', Validators.required],
    active: [true],
    skills: [''],
    address: [''],
  });

  get isEdit(): boolean { return this.id !== null; }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    const pw = this.form.controls.password;
    if (!idParam) {
      pw.setValidators([Validators.required, Validators.minLength(6)]);
      pw.updateValueAndValidity();
      return;
    }
    pw.setValidators([Validators.minLength(6)]);
    this.id = Number(idParam);
    this.loading.set(true);
    this.api.getEmployeeById(this.id)
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (e) => this.form.patchValue({
          fullName: e.fullName ?? '',
          email: e.email ?? '',
          age: e.age ?? null,
          gender: e.gender ?? '',
          department: e.department ?? '',
          employmentType: e.employmentType ?? '',
          joiningDate: (e.joiningDate ?? '').slice(0, 10),
          active: !!e.active,
          skills: (e.skills ?? []).join(', '),
          address: e.address ?? '',
        }),
        error: () => this.error.set('Could not load this employee. Go back to the list and try again.'),
      });
  }

  invalid(name: keyof typeof this.form.controls): boolean {
    const c = this.form.controls[name];
    return c.invalid && (c.touched || c.dirty);
  }

  submit(): void {
    this.error.set('');
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.error.set('Fix the highlighted fields and save again.');
      return;
    }
    const v = this.form.getRawValue();
    const payload: Employee = {
      fullName: v.fullName.trim(),
      email: v.email.trim(),
      age: Number(v.age),
      gender: v.gender,
      department: v.department.trim(),
      skills: v.skills.split(',').map((s) => s.trim()).filter(Boolean),
      employmentType: v.employmentType.trim(),
      active: v.active,
      joiningDate: v.joiningDate,
      address: v.address.trim(),
    };
    if (v.password) payload.password = v.password;

    this.saving.set(true);
    const req = this.isEdit ? this.api.updateEmployee(this.id!, payload) : this.api.createEmployee(payload);
    req.pipe(finalize(() => this.saving.set(false))).subscribe({
      next: () => {
        this.toast.success(this.isEdit ? 'Employee updated.' : 'Employee added.');
        this.router.navigate(['/employees']);
      },
      error: (err: HttpErrorResponse) => {
        this.error.set(
          err.status === 0 ? 'Cannot reach the server.'
          : err.status === 409 ? 'An employee with this email already exists.'
          : err.error?.message ?? 'Could not save the employee. Check the details and try again.'
        );
      },
    });
  }
}
