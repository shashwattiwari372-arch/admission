import { Component, OnInit, inject } from '@angular/core';
import { DatePipe, DecimalPipe } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
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

  items: CandidateExp[] = [];
  appId: number | null = null;
  loading = true;
  errorMessage = '';
  successMessage = '';

  ngOnInit(): void {
    const appId = this.route.snapshot.queryParamMap.get('appId');
    this.appId = appId ? Number(appId) : null;
    this.load();
  }

  load(): void {
    this.loading = true;
    this.api.getAll(this.appId).subscribe({
      next: (data) => {
        this.items = data;
        this.loading = false;
      },
      error: () => {
        this.errorMessage = 'Could not load experience records. Check that the server is running.';
        this.loading = false;
      },
    });
  }

  add(): void {
    this.router.navigate(['/ums/candidate-exp/add'], this.appId ? { queryParams: { appId: this.appId } } : {});
  }

  edit(item: CandidateExp): void {
    this.router.navigate(['/ums/candidate-exp', item.id, 'edit']);
  }

  remove(item: CandidateExp): void {
    if (!confirm(`Delete experience at "${item.employerName}"?`)) return;
    this.api.delete(item.id!).subscribe({
      next: () => {
        this.successMessage = 'Experience deleted.';
        this.items = this.items.filter((i) => i.id !== item.id);
      },
      error: () => (this.errorMessage = 'Could not delete this record.'),
    });
  }

  duration(i: CandidateExp): string {
    return `${i.noOfYears ?? 0}y ${i.noOfMonths ?? 0}m ${i.noOfDays ?? 0}d`;
  }
}
