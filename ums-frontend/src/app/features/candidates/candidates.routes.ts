import { Routes } from '@angular/router';

// Mounted at /candidates by app.routes.ts
export const CANDIDATE_ROUTES: Routes = [
  {
    path: '',
    title: 'Candidates · UMS',
    loadComponent: () => import('./candidate-list/candidate-list').then((m) => m.CandidateList),
  },
  {
    path: 'new',
    title: 'New candidate · UMS',
    data: { crumb: 'New candidate' },
    loadComponent: () => import('./candidate-form/candidate-form').then((m) => m.CandidateForm),
  },
  {
    path: ':id/edit',
    title: 'Edit candidate · UMS',
    data: { crumb: 'Edit candidate' },
    loadComponent: () => import('./candidate-form/candidate-form').then((m) => m.CandidateForm),
  },
];
