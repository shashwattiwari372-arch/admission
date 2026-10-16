import { Routes } from '@angular/router';
// import { authGuard } from '../core/guards/auth.guard'; // re-enable with the guards below once login works

// Spread these inside the `ums` children array in app.routes.ts
export const CANDIDATE_EXP_ROUTES: Routes = [
  {
    path: 'candidate-exp',
    // canActivate: [authGuard],
    loadComponent: () =>
      import('./candidate-exp-list/candidate-exp-list').then((m) => m.CandidateExpList),
  },
  {
    path: 'candidate-exp/add',
    // canActivate: [authGuard],
    loadComponent: () =>
      import('./candidate-exp-form/candidate-exp-form').then((m) => m.CandidateExpForm),
  },
  {
    path: 'candidate-exp/:id/edit',
    // canActivate: [authGuard],
    loadComponent: () =>
      import('./candidate-exp-form/candidate-exp-form').then((m) => m.CandidateExpForm),
  },
];
