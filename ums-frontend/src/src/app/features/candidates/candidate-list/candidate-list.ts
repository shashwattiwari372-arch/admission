import { Component, OnInit, computed, inject, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { finalize } from 'rxjs';
import { CandidateProfile } from '../../../core/models/candidate-profile.model';
import { CandidateProfileService } from '../../../core/services/candidate-profile.service';
import { ToastService } from '../../../core/services/toast.service';
import { ConfirmDialog } from '../../../shared/confirm-dialog/confirm-dialog';

@Component({
  selector: 'app-candidate-list',
  imports: [RouterLink, ConfirmDialog],
  templateUrl: './candidate-list.html',
})
export class CandidateList implements OnInit {
  private api = inject(CandidateProfileService);
  private toast = inject(ToastService);

  items = signal<CandidateProfile[]>([]);
  loading = signal(true);
  error = signal('');
  query = signal('');
  toDelete = signal<CandidateProfile | null>(null);
  deleting = signal(false);

  filtered = computed(() => {
    const q = this.query().trim().toLowerCase();
    if (!q) return this.items();
    return this.items().filter((c) =>
      [c.fullName, c.email, c.mobileNo, c.city, c.state, c.category, String(c.id ?? '')]
        .some((v) => (v ?? '').toLowerCase().includes(q))
    );
  });

  ngOnInit(): void { this.load(); }

  load(): void {
    this.loading.set(true);
    this.error.set('');
    this.api.getAllCandidates()
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (data) => this.items.set(Array.isArray(data) ? data : []),
        error: (err) => this.error.set(
          err.status === 0 ? 'Cannot reach the server. Check that the backend is running on port 8080.' : 'Could not load candidates.'
        ),
      });
  }

  onSearch(ev: Event): void { this.query.set((ev.target as HTMLInputElement).value); }

  location(c: CandidateProfile): string {
    return [c.city, c.state].filter((x) => !!x).join(', ') || '—';
  }

  initials(name: string): string {
    return name.split(/\s+/).filter(Boolean).slice(0, 2).map((p) => p[0].toUpperCase()).join('') || '?';
  }

  confirmDelete(): void {
    const target = this.toDelete();
    if (!target?.id) return;
    this.deleting.set(true);
    this.api.deleteCandidate(target.id)
      .pipe(finalize(() => this.deleting.set(false)))
      .subscribe({
        next: () => {
          this.items.update((l) => l.filter((x) => x.id !== target.id));
          this.toDelete.set(null);
          this.toast.success(`${target.fullName} was deleted.`);
        },
        error: () => {
          this.toDelete.set(null);
          this.toast.error('Could not delete this candidate. They may have linked records.');
        },
      });
  }
}
