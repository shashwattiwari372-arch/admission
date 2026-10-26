import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from '../config/api.config';
import { Row, TableDef } from '../../features/tables/table.models';

/** Talks to the generic CRUD endpoints (/api/<table-name>) for any table. */
@Injectable({ providedIn: 'root' })
export class TableApiService {
  private http = inject(HttpClient);

  private url(t: TableDef, id?: number | string): string {
    return `${API_URL}${t.endpoint}${id !== undefined ? '/' + id : ''}`;
  }

  getAll(t: TableDef): Observable<Row[]> { return this.http.get<Row[]>(this.url(t)); }
  getOne(t: TableDef, id: number | string): Observable<Row> { return this.http.get<Row>(this.url(t, id)); }
  create(t: TableDef, body: Row): Observable<Row> { return this.http.post<Row>(this.url(t), body); }
  update(t: TableDef, id: number | string, body: Row): Observable<Row> { return this.http.put<Row>(this.url(t, id), body); }
  remove(t: TableDef, id: number | string): Observable<void> { return this.http.delete<void>(this.url(t, id)); }
}
