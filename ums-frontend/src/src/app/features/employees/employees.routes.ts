import { Routes } from '@angular/router';

// Mounted at /employees by app.routes.ts
export const EMPLOYEE_ROUTES: Routes = [
  {
    path: '',
    title: 'Employees · UMS',
    loadComponent: () => import('./employee-list/employee-list').then((m) => m.EmployeeList),
  },
  {
    path: 'new',
    title: 'New employee · UMS',
    data: { crumb: 'New employee' },
    loadComponent: () => import('./employee-form/employee-form').then((m) => m.EmployeeForm),
  },
  {
    path: ':id/edit',
    title: 'Edit employee · UMS',
    data: { crumb: 'Edit employee' },
    loadComponent: () => import('./employee-form/employee-form').then((m) => m.EmployeeForm),
  },
];
