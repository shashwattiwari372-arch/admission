import { Routes } from '@angular/router';
import { authGuard, guestGuard } from './core/guards/auth.guard';
import { Shell } from './layout/shell/shell';

export const routes: Routes = [
  // ---------- public ----------
  {
    path: 'login',
    canActivate: [guestGuard],
    title: 'Sign in · UMS',
    loadComponent: () => import('./pages/login/login').then((m) => m.Login),
  },

  // ---------- signed-in area (sidebar + top bar) ----------
  {
    path: '',
    component: Shell,
    canActivate: [authGuard],
    children: [
      { path: '', pathMatch: 'full', redirectTo: 'dashboard' },
      {
        path: 'dashboard',
        title: 'Dashboard · UMS',
        data: { crumb: 'Dashboard' },
        loadComponent: () => import('./pages/dashboard/dashboard').then((m) => m.Dashboard),
      },
      {
        path: 'employees',
        data: { crumb: 'Employees' },
        loadChildren: () => import('./features/employees/employees.routes').then((m) => m.EMPLOYEE_ROUTES),
      },
      {
        path: 'candidates',
        data: { crumb: 'Candidates' },
        loadChildren: () => import('./features/candidates/candidates.routes').then((m) => m.CANDIDATE_ROUTES),
      },
      {
        path: 'experience',
        data: { crumb: 'Experience' },
        loadChildren: () => import('./candidate-exp/candidate-exp.routes').then((m) => m.CANDIDATE_EXP_ROUTES),
      },
    ],
  },

  // ---------- old links keep working ----------
  { path: 'ums', pathMatch: 'full', redirectTo: 'dashboard' },
  { path: 'ums/candidate-exp', redirectTo: 'experience' },
  { path: 'ums/candidate-exp/add', redirectTo: 'experience/add' },

  // ---------- 404 ----------
  {
    path: '**',
    title: 'Page not found · UMS',
    loadComponent: () => import('./pages/not-found/not-found').then((m) => m.NotFound),
  },
];
