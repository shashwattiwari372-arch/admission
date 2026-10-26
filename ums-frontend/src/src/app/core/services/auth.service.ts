import { Injectable, PLATFORM_ID, computed, inject, signal } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { API_URL } from '../config/api.config';

export interface LoginRequest {
  username: string;
  password: string;
}

export interface LoginResponse {
  message: string;
  userId: number;
  fullName: string;
  username: string;
  email: string;
  token: string;
}

export interface SessionUser {
  userId: number;
  fullName: string;
  username: string;
  email: string;
}

const KEYS = ['token', 'userId', 'username', 'fullName', 'email'] as const;

@Injectable({ providedIn: 'root' })
export class AuthService {
  private http = inject(HttpClient);
  private isBrowser = isPlatformBrowser(inject(PLATFORM_ID));
  private apiUrl = `${API_URL}/auth`;

  private _user = signal<SessionUser | null>(this.restore());

  /** Current signed-in user (null when signed out). */
  readonly user = this._user.asReadonly();
  readonly loggedIn = computed(() => this._user() !== null);
  readonly initials = computed(() => {
    const name = this._user()?.fullName || this._user()?.username || '';
    return (
      name
        .split(/\s+/)
        .filter(Boolean)
        .slice(0, 2)
        .map((p) => p[0].toUpperCase())
        .join('') || 'U'
    );
  });

  login(request: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.apiUrl}/login`, request).pipe(
      tap((res) => {
        if (this.isBrowser) {
          localStorage.setItem('token', res.token);
          localStorage.setItem('userId', String(res.userId));
          localStorage.setItem('username', res.username);
          localStorage.setItem('fullName', res.fullName);
          localStorage.setItem('email', res.email);
        }
        this._user.set({
          userId: res.userId,
          fullName: res.fullName,
          username: res.username,
          email: res.email,
        });
      })
    );
  }

  logout(): void {
    if (this.isBrowser) KEYS.forEach((k) => localStorage.removeItem(k));
    this._user.set(null);
  }

  getToken(): string | null {
    return this.isBrowser ? localStorage.getItem('token') : null;
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  private restore(): SessionUser | null {
    if (!this.isBrowser || !localStorage.getItem('token')) return null;
    return {
      userId: Number(localStorage.getItem('userId') ?? 0),
      fullName: localStorage.getItem('fullName') ?? '',
      username: localStorage.getItem('username') ?? '',
      email: localStorage.getItem('email') ?? '',
    };
  }
}
