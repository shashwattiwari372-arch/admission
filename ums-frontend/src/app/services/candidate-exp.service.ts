import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CandidateExp } from '../models/candidate-exp.model';

@Injectable({ providedIn: 'root' })
export class CandidateExpService {
  private http = inject(HttpClient);
  private url = 'http://localhost:8080/api/candidate-exp';

  getAll(): Observable<CandidateExp[]> {
    return this.http.get<CandidateExp[]>(this.url);
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
