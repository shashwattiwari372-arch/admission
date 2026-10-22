import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from '../config/api.config';

import { State } from '../models/state.model';

@Injectable({
  providedIn: 'root'
})
export class StateService {

  private apiUrl = `${API_URL}/states`;

  constructor(private http: HttpClient) {}

  getAllStates(): Observable<State[]> {
    return this.http.get<State[]>(this.apiUrl);
  }
}