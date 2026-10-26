import { Routes } from '@angular/router';

// Mounted at /experience by app.routes.ts
export const CANDIDATE_EXP_ROUTES: Routes = [
  {
    path: '',
    title: 'Experience · UMS',
    loadComponent: () => import('./candidate-exp-list/candidate-exp-list').then((m) => m.CandidateExpList),
  },
  {
    path: 'add',
    title: 'Add experience · UMS',
    data: { crumb: 'Add experience' },
    loadComponent: () => import('./candidate-exp-form/candidate-exp-form').then((m) => m.CandidateExpForm),
  },
  {
    path: ':id/edit',
    title: 'Edit experience · UMS',
    data: { crumb: 'Edit experience' },
    loadComponent: () => import('./candidate-exp-form/candidate-exp-form').then((m) => m.CandidateExpForm),
  },
];
