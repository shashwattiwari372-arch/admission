import { Component, OnInit, computed, inject, signal } from '@angular/core';
import { DatePipe, DecimalPipe } from '@angular/common';
import { Router } from '@angular/router';
import { finalize } from 'rxjs';
import { CandidateExpService } from '../../services/candidate-exp.service';
import { CandidateExp } from '../../models/candidate-exp.model';

@Component({
  selector: 'app-experience-list',
  standalone: true,
  imports: [DatePipe, DecimalPipe],
  templateUrl: './experience-list.component.html',
  styleUrl: './experience-shared.css'
})
export class ExperienceListComponent implements OnInit {
  private service = inject(CandidateExpService);
  private router = inject(Router);

  items = signal<CandidateExp[]>([]);
  loading = signal(true);
  errorMessage = signal('');
  query = signal('');
  toDelete = signal<CandidateExp | null>(null);
  deleting = signal(false);

  filtered = computed(() => {
    const q = this.query().trim().toLowerCase();
    if (!q) return this.items();
    return this.items().filter(e =>
      [e.employerName, e.designation, e.jobType, String(e.appId)]
        .some(v => (v ?? '').toLowerCase().includes(q))
    );
  });

  ngOnInit() { this.load(); }

  load() {
    this.loading.set(true);
    this.errorMessage.set('');
    this.service.getAll()
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: data => {
          const rows = Array.isArray(data) ? data : (data as any)?.content ?? [];
          this.items.set(rows);
        },
        error: err => {
          console.error('Load failed', err);
          this.errorMessage.set(
            err.status === 401 || err.status === 403 ? 'Your session has expired. Please log in again.'
            : err.status === 0 ? 'Cannot reach the server. Check that the backend is running and CORS allows http://localhost:4200.'
            : 'Could not load experience records. Check the backend console for the error.'
          );
        }
      });
  }

  onSearch(ev: Event) { this.query.set((ev.target as HTMLInputElement).value); }

  duration(e: CandidateExp): string {
    const parts: string[] = [];
    if (e.noOfYears) parts.push(`${e.noOfYears}y`);
    if (e.noOfMonths) parts.push(`${e.noOfMonths}m`);
    if (e.noOfDays) parts.push(`${e.noOfDays}d`);
    return parts.length ? parts.join(' ') : '—';
  }

  add() { this.router.navigate(['/experience/new']); }
  edit(id: number) { this.router.navigate(['/experience/edit', id]); }

  askDelete(e: CandidateExp) { this.toDelete.set(e); }
  cancelDelete() { if (!this.deleting()) this.toDelete.set(null); }

  confirmDelete() {
    const target = this.toDelete();
    if (!target?.id) return;
    this.deleting.set(true);
    this.service.delete(target.id)
      .pipe(finalize(() => this.deleting.set(false)))
      .subscribe({
        next: () => {
          this.items.update(list => list.filter(x => x.id !== target.id));
          this.toDelete.set(null);
        },
        error: () => {
          this.toDelete.set(null);
          this.errorMessage.set('Could not delete the record. Try again.');
        }
      });
  }
}
