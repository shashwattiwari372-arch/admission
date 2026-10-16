import { Routes } from '@angular/router';

import { CANDIDATE_EXP_ROUTES } from './candidate-exp/candidate-exp.routes';

// TEMPORARY minimal routes: only the candidate-exp pages.
// The login, dashboard, users and candidates routes were removed because
// their component files are not at the paths they were importing from.
// Add them back once you know where those files really are.

export const routes: Routes = [

  {
    path: 'ums',

    children: [

      {
        path: '',
        redirectTo: 'candidate-exp',
        pathMatch: 'full'
      },

      // /ums/candidate-exp, /ums/candidate-exp/add, /ums/candidate-exp/:id/edit
      ...CANDIDATE_EXP_ROUTES

    ]
  },

  {
    path: '',
    redirectTo: 'ums',
    pathMatch: 'full'
  },

  {
    path: '**',
    redirectTo: 'ums'
  }

];
