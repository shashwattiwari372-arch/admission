
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from '../config/api.config';

import { Employee } from '../models/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiUrl = `${API_URL}/employees`;


  constructor(
    private http: HttpClient
  ) {}


  // =====================================================
  // GET ALL EMPLOYEES
  // =====================================================

  getAllEmployees(): Observable<Employee[]> {

    return this.http.get<Employee[]>(
      this.apiUrl
    );

  }


  // =====================================================
  // GET EMPLOYEE BY ID
  // =====================================================

  getEmployeeById(
    id: number
  ): Observable<Employee> {

    return this.http.get<Employee>(
      `${this.apiUrl}/${id}`
    );

  }


  // =====================================================
  // CREATE EMPLOYEE
  // =====================================================

  createEmployee(
    employee: Employee
  ): Observable<Employee> {

    return this.http.post<Employee>(
      this.apiUrl,
      employee
    );

  }


  // =====================================================
  // CREATE EMPLOYEE WITH FILES
  // =====================================================

  createEmployeeWithFiles(
    formData: FormData
  ): Observable<Employee> {

    return this.http.post<Employee>(
      `${this.apiUrl}/with-files`,
      formData
    );

  }


  // =====================================================
  // UPDATE EMPLOYEE
  // =====================================================

  updateEmployee(
    id: number,
    employee: Employee
  ): Observable<Employee> {

    return this.http.put<Employee>(
      `${this.apiUrl}/${id}`,
      employee
    );

  }


  // =====================================================
  // DELETE EMPLOYEE
  // =====================================================

  deleteEmployee(
    id: number
  ): Observable<void> {

    return this.http.delete<void>(
      `${this.apiUrl}/${id}`
    );

  }


  // =====================================================
  // GET EMPLOYEE FILE
  // =====================================================

  getEmployeeFile(
    filename: string
  ): Observable<Blob> {

    return this.http.get(
      `${this.apiUrl}/files/${filename}`,
      {
        responseType: 'blob'
      }
    );

  }
  updateEmployeeWithFiles(
  id: number,
  formData: FormData
): Observable<Employee> {

  return this.http.put<Employee>(
    `${this.apiUrl}/${id}/with-files`,
    formData
  );
}

}