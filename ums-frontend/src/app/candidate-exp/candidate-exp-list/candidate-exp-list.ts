import { Component, computed, inject, signal } from '@angular/core';
import { DatePipe, DecimalPipe } from '@angular/common';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { finalize } from 'rxjs';
import { CandidateExp } from '../candidate-exp.model';
import { CandidateExpService } from '../candidate-exp.service';
import { ToastService } from '../../core/services/toast.service';
import { ConfirmDialog } from '../../shared/confirm-dialog/confirm-dialog';

@Component({
  selector: 'app-candidate-exp-list',
  imports: [DatePipe, DecimalPipe, RouterLink, ConfirmDialog],
  templateUrl: './candidate-exp-list.html',
})
export class CandidateExpList {
  private api = inject(CandidateExpService);
  private route = inject(ActivatedRoute);
  private toast = inject(ToastService);

  appId = signal<number | null>(null);
  items = signal<CandidateExp[]>([]);
  loading = signal(true);
  error = signal('');
  query = signal('');
  toDelete = signal<CandidateExp | null>(null);
  deleting = signal(false);

  filtered = computed(() => {
    const q = this.query().trim().toLowerCase();
    if (!q) return this.items();
    return this.items().filter((e) =>
      [e.employerName, e.designation, e.jobType, String(e.appId)].some((v) => (v ?? '').toLowerCase().includes(q))
    );
  });

  constructor() {
    // re-runs when the ?appId= filter changes, without a page reload
    this.route.queryParamMap.pipe(takeUntilDestroyed()).subscribe((p) => {
      const raw = p.get('appId');
      this.appId.set(raw && !isNaN(Number(raw)) ? Number(raw) : null);
      this.load();
    });
  }

  load(): void {
    this.loading.set(true);
    this.error.set('');
    this.api.getAll(this.appId())
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (data) => this.items.set(Array.isArray(data) ? data : (data as any)?.content ?? []),
        error: (err) => this.error.set(
          err.status === 0 ? 'Cannot reach the server. Check that the backend is running on port 8080.' : 'Could not load experience records.'
        ),
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

  confirmDelete(): void {
    const target = this.toDelete();
    if (!target?.id) return;
    this.deleting.set(true);
    this.api.delete(target.id)
      .pipe(finalize(() => this.deleting.set(false)))
      .subscribe({
        next: () => {
          this.items.update((l) => l.filter((x) => x.id !== target.id));
          this.toDelete.set(null);
          this.toast.success('Experience record deleted.');
        },
        error: () => {
          this.toDelete.set(null);
          this.toast.error('Could not delete this record.');
        },
      });
  }
}
