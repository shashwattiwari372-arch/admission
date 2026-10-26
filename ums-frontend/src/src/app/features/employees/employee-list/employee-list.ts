import { Component, OnInit, computed, inject, signal } from '@angular/core';
import { DatePipe } from '@angular/common';
import { RouterLink } from '@angular/router';
import { finalize } from 'rxjs';
import { Employee } from '../../../core/models/employee.model';
import { EmployeeService } from '../../../core/services/employee.service';
import { ToastService } from '../../../core/services/toast.service';
import { ConfirmDialog } from '../../../shared/confirm-dialog/confirm-dialog';

type StatusFilter = 'all' | 'active' | 'inactive';

@Component({
  selector: 'app-employee-list',
  imports: [RouterLink, DatePipe, ConfirmDialog],
  templateUrl: './employee-list.html',
})
export class EmployeeList implements OnInit {
  private api = inject(EmployeeService);
  private toast = inject(ToastService);

  items = signal<Employee[]>([]);
  loading = signal(true);
  error = signal('');
  query = signal('');
  status = signal<StatusFilter>('all');
  toDelete = signal<Employee | null>(null);
  deleting = signal(false);

  filters: { id: StatusFilter; label: string }[] = [
    { id: 'all', label: 'All' },
    { id: 'active', label: 'Active' },
    { id: 'inactive', label: 'Inactive' },
  ];

  filtered = computed(() => {
    const q = this.query().trim().toLowerCase();
    const st = this.status();
    return this.items().filter((e) => {
      if (st === 'active' && !e.active) return false;
      if (st === 'inactive' && e.active) return false;
      if (!q) return true;
      return [e.fullName, e.email, e.department, e.employmentType].some((v) => (v ?? '').toLowerCase().includes(q));
    });
  });

  ngOnInit(): void { this.load(); }

  load(): void {
    this.loading.set(true);
    this.error.set('');
    this.api.getAllEmployees()
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (data) => this.items.set(Array.isArray(data) ? data : []),
        error: (err) => this.error.set(
          err.status === 0 ? 'Cannot reach the server. Check that the backend is running on port 8080.' : 'Could not load employees.'
        ),
      });
  }

  onSearch(ev: Event): void { this.query.set((ev.target as HTMLInputElement).value); }

  initials(name: string): string {
    return name.split(/\s+/).filter(Boolean).slice(0, 2).map((p) => p[0].toUpperCase()).join('') || '?';
  }

  confirmDelete(): void {
    const target = this.toDelete();
    if (!target?.id) return;
    this.deleting.set(true);
    this.api.deleteEmployee(target.id)
      .pipe(finalize(() => this.deleting.set(false)))
      .subscribe({
        next: () => {
          this.items.update((l) => l.filter((x) => x.id !== target.id));
          this.toDelete.set(null);
          this.toast.success(`${target.fullName} was deleted.`);
        },
        error: () => {
          this.toDelete.set(null);
          this.toast.error('Could not delete this employee.');
        },
      });
  }
}
