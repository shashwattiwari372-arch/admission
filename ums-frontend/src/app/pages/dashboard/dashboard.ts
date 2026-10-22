import { Component, OnInit, computed, inject, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { catchError, forkJoin, of } from 'rxjs';
import { AuthService } from '../../core/services/auth.service';
import { EmployeeService } from '../../core/services/employee.service';
import { CandidateProfileService } from '../../core/services/candidate-profile.service';
import { CandidateProfile } from '../../core/models/candidate-profile.model';
import { CandidateExpService } from '../../candidate-exp/candidate-exp.service';

@Component({
  selector: 'app-dashboard',
  imports: [RouterLink],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard implements OnInit {
  private auth = inject(AuthService);
  private employees = inject(EmployeeService);
  private candidates = inject(CandidateProfileService);
  private experience = inject(CandidateExpService);

  loading = signal(true);
  failed = signal(false);
  employeeCount = signal<number | null>(null);
  candidateCount = signal<number | null>(null);
  experienceCount = signal<number | null>(null);
  activeEmployees = signal<number | null>(null);
  recent = signal<CandidateProfile[]>([]);

  firstName = computed(() => (this.auth.user()?.fullName || this.auth.user()?.username || '').split(' ')[0]);
  greeting = (() => {
    const h = new Date().getHours();
    return h < 12 ? 'Good morning' : h < 17 ? 'Good afternoon' : 'Good evening';
  })();

  stats = computed(() => [
    { label: 'Employees', value: this.employeeCount(), note: this.activeEmployees() !== null ? `${this.activeEmployees()} active` : '', link: '/employees' },
    { label: 'Candidates', value: this.candidateCount(), note: 'profiles on file', link: '/candidates' },
    { label: 'Experience records', value: this.experienceCount(), note: 'employment entries', link: '/experience' },
  ]);

  ngOnInit(): void { this.load(); }

  load(): void {
    this.loading.set(true);
    this.failed.set(false);
    let errors = 0;
    const safe = <T,>(fallback: T) => catchError(() => { errors++; return of(fallback); });

    forkJoin({
      emp: this.employees.getAllEmployees().pipe(safe(null as any)),
      cand: this.candidates.getAllCandidates().pipe(safe(null as any)),
      exp: this.experience.getAll().pipe(safe(null as any)),
    }).subscribe(({ emp, cand, exp }) => {
      if (Array.isArray(emp)) {
        this.employeeCount.set(emp.length);
        this.activeEmployees.set(emp.filter((e) => e.active).length);
      }
      if (Array.isArray(cand)) {
        this.candidateCount.set(cand.length);
        this.recent.set([...cand].sort((a, b) => (b.id ?? 0) - (a.id ?? 0)).slice(0, 5));
      }
      if (Array.isArray(exp)) this.experienceCount.set(exp.length);
      this.failed.set(errors === 3);
      this.loading.set(false);
    });
  }

  initials(name: string): string {
    return name.split(/\s+/).filter(Boolean).slice(0, 2).map((p) => p[0].toUpperCase()).join('') || '?';
  }
}
