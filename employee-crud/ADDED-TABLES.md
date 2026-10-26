# What was added (all 37 tables of the `admission` database)

Nothing existing was changed except one additive edit: `state/StateController.java`
(POST / PUT / DELETE added; the original GET is untouched).

## Backend (package `com.example.employeecrud.tables`)
- `base/BaseCrudController` – one generic controller: GET list, GET one, POST, PUT, DELETE.
- `entity/`, `repository/`, `controller/` – one entity, repository and controller per table
  (32 tables). REST path = table name with `-` instead of `_`, e.g. `candidate_quali` -> `/api/candidate-quali`.
- `controller/AppUserController` – CRUD for `app_users` at `/api/app-users`.
- `updateBy / updateDt / updateTime` are filled automatically on every save.
- Already existing and left as they were: `employees`, `candidate_profile`, `candidate_exp`.

## Frontend (`src/app/features/tables`)
- Menu item **All tables** -> `/tables` (index of every table, with search).
- `/tables/<table-name>` list (search, paging, delete) and `/tables/<table-name>/new|:id/edit` form.
- `tables.config.ts` describes every table / column.
