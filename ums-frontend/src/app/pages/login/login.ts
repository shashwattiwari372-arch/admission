import { Component, inject, signal } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { finalize } from 'rxjs';
import { AuthService } from '../../core/services/auth.service';
import { ToastService } from '../../core/services/toast.service';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  private fb = inject(FormBuilder);
  private auth = inject(AuthService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private toast = inject(ToastService);

  loading = signal(false);
  error = signal('');
  showPassword = signal(false);

  form = this.fb.nonNullable.group({
    username: ['', [Validators.required]],
    password: ['', [Validators.required]],
  });

  invalid(name: 'username' | 'password'): boolean {
    const c = this.form.controls[name];
    return c.invalid && (c.touched || c.dirty);
  }

  submit(): void {
    this.error.set('');
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.loading.set(true);
    this.auth
      .login(this.form.getRawValue())
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (res) => {
          this.toast.success(`Welcome back, ${res.fullName || res.username}.`);
          const back = this.route.snapshot.queryParamMap.get('returnUrl');
          // only follow in-app paths (blocks //evil.com style redirects)
          const safe = back && back.startsWith('/') && !back.startsWith('//') && !back.startsWith('/login');
          this.router.navigateByUrl(safe ? back : '/dashboard');
        },
        error: (err: HttpErrorResponse) => {
          this.error.set(
            err.status === 0
              ? 'Cannot reach the server. Make sure the backend is running on port 8080.'
              : err.status === 401 || err.status === 403
                ? 'Wrong username or password.'
                : err.error?.message ?? 'Sign-in failed. Please try again.'
          );
        },
      });
  }
}
