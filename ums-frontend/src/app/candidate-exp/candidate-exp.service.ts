import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { CandidateExp } from './candidate-exp.model';

@Injectable({ providedIn: 'root' })
export class CandidateExpService {
  private http = inject(HttpClient);
  private baseUrl = 'http://localhost:8080/api/candidate-exp';

  getAll(appId?: number | null): Observable<CandidateExp[]> {
    let params = new HttpParams();
    if (appId) params = params.set('appId', appId);
    return this.http.get<CandidateExp[]>(this.baseUrl, { params });
  }

  getById(id: number): Observable<CandidateExp> {
    return this.http.get<CandidateExp>(`${this.baseUrl}/${id}`);
  }

  create(body: CandidateExp): Observable<CandidateExp> {
    return this.http.post<CandidateExp>(this.baseUrl, body);
  }

  update(id: number, body: CandidateExp): Observable<CandidateExp> {
    return this.http.put<CandidateExp>(`${this.baseUrl}/${id}`, body);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
