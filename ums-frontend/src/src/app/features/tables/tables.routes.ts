import { ResolveFn, Routes } from '@angular/router';
import { findTable } from './tables.config';

const tableLabel: ResolveFn<string> = (route) => findTable(route.paramMap.get('table'))?.label ?? 'Table';
const tableTitle: ResolveFn<string> = (route) =>
  `${findTable(route.paramMap.get('table'))?.label ?? 'Table'} · UMS`;

// Mounted at /tables by app.routes.ts
export const TABLE_ROUTES: Routes = [
  {
    path: '',
    title: 'All tables · UMS',
    loadComponent: () => import('./tables-home/tables-home').then((m) => m.TablesHome),
  },
  {
    path: ':table',
    title: tableTitle,
    resolve: { crumb: tableLabel },
    children: [
      {
        path: '',
        loadComponent: () => import('./table-list/table-list').then((m) => m.TableList),
      },
      {
        path: 'new',
        title: tableTitle,
        data: { crumb: 'New' },
        loadComponent: () => import('./table-form/table-form').then((m) => m.TableForm),
      },
      {
        path: ':id/edit',
        title: tableTitle,
        data: { crumb: 'Edit' },
        loadComponent: () => import('./table-form/table-form').then((m) => m.TableForm),
      },
    ],
  },
];
