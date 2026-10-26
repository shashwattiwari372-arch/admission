import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from '../config/api.config';

import { CandidateProfile } from '../models/candidate-profile.model';

@Injectable({
  providedIn: 'root'
})
export class CandidateProfileService {

  private apiUrl = `${API_URL}/candidates`;

  constructor(private http: HttpClient) {}

  getAllCandidates(): Observable<CandidateProfile[]> {
    return this.http.get<CandidateProfile[]>(this.apiUrl);
  }

  getCandidateById(id: number): Observable<CandidateProfile> {
    return this.http.get<CandidateProfile>(
      `${this.apiUrl}/${id}`
    );
  }

  createCandidate(
    candidate: CandidateProfile
  ): Observable<CandidateProfile> {
    return this.http.post<CandidateProfile>(
      this.apiUrl,
      candidate
    );
  }

  updateCandidate(
    id: number,
    candidate: CandidateProfile
  ): Observable<CandidateProfile> {
    return this.http.put<CandidateProfile>(
      `${this.apiUrl}/${id}`,
      candidate
    );
  }

  deleteCandidate(id: number): Observable<void> {
    return this.http.delete<void>(
      `${this.apiUrl}/${id}`
    );
  }
}