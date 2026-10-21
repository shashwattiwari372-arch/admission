import { Component, OnInit, computed, inject, signal } from '@angular/core';
import { DatePipe, DecimalPipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { finalize } from 'rxjs';
import { CandidateExp } from '../candidate-exp.model';
import { CandidateExpService } from '../candidate-exp.service';

@Component({
  selector: 'app-candidate-exp-list',
  imports: [DatePipe, DecimalPipe],
  templateUrl: './candidate-exp-list.html',
  styleUrl: './candidate-exp-list.css',
})
export class CandidateExpList implements OnInit {
  private api = inject(CandidateExpService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  appId: number | null = null;
  items = signal<CandidateExp[]>([]);
  loading = signal(true);
  errorMessage = signal('');
  query = signal('');
  toDelete = signal<CandidateExp | null>(null);
  deleting = signal(false);

  filtered = computed(() => {
    const q = this.query().trim().toLowerCase();
    if (!q) return this.items();
    return this.items().filter((e) =>
      [e.employerName, e.designation, e.jobType, String(e.appId)]
        .some((v) => (v ?? '').toLowerCase().includes(q))
    );
  });

  ngOnInit(): void {
    const appId = this.route.snapshot.queryParamMap.get('appId');
    this.appId = appId ? Number(appId) : null;
    this.load();
  }

  load(): void {
    this.loading.set(true);
    this.errorMessage.set('');
    this.api.getAll(this.appId)
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (data) => this.items.set(Array.isArray(data) ? data : (data as any)?.content ?? []),
        error: (err) => {
          console.error('Load failed', err);
          this.errorMessage.set(
            err.status === 401 || err.status === 403
              ? 'Your session has expired. Please log in again.'
              : err.status === 0
                ? 'Cannot reach the server. Check that the backend is running.'
                : 'Could not load experience records.'
          );
        },
      });
  }

  onSearch(ev: Event): void { this.query.set((ev.target as HTMLInputElement).value); }

  duration(e: CandidateExp): string {
    const parts: string[] = [];
    if (e.noOfYears) parts.push(`${e.noOfYears}y`);
    if (e.noOfMonths) parts.push(`${e.noOfMonths}m`);
    if (e.noOfDays) parts.push(`${e.noOfDays}d`);
    return parts.length ? parts.join(' ') : '—';
  }

  add(): void {
    this.router.navigate(['/ums/candidate-exp/add'], this.appId ? { queryParams: { appId: this.appId } } : {});
  }
  edit(id: number): void { this.router.navigate(['/ums/candidate-exp', id, 'edit']); }

  askDelete(e: CandidateExp): void { this.toDelete.set(e); }
  cancelDelete(): void { if (!this.deleting()) this.toDelete.set(null); }

  confirmDelete(): void {
    const target = this.toDelete();
    if (!target?.id) return;
    this.deleting.set(true);
    this.api.delete(target.id)
      .pipe(finalize(() => this.deleting.set(false)))
      .subscribe({
        next: () => {
          this.items.update((list) => list.filter((x) => x.id !== target.id));
          this.toDelete.set(null);
        },
        error: () => {
          this.toDelete.set(null);
          this.errorMessage.set('Could not delete this record.');
        },
      });
  }
}