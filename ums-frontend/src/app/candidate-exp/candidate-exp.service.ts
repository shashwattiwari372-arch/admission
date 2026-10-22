import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CandidateExp } from './candidate-exp.model';
import { API_URL } from '../core/config/api.config';

@Injectable({ providedIn: 'root' })
export class CandidateExpService {
  private http = inject(HttpClient);
  private url = `${API_URL}/candidate-exp`;

  getAll(appId?: number | null): Observable<CandidateExp[]> {
    let params = new HttpParams();
    if (appId != null) params = params.set('appId', appId);
    return this.http.get<CandidateExp[]>(this.url, { params });
  }

  getById(id: number): Observable<CandidateExp> {
    return this.http.get<CandidateExp>(`${this.url}/${id}`);
  }

  create(body: CandidateExp): Observable<CandidateExp> {
    return this.http.post<CandidateExp>(this.url, body);
  }

  update(id: number, body: CandidateExp): Observable<CandidateExp> {
    return this.http.put<CandidateExp>(`${this.url}/${id}`, body);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
