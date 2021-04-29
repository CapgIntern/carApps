import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';
@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private baseURL = "http://localhost:8800/appointments";

  constructor(private httpClient: HttpClient) { }
  
  getAppointmentsList(): Observable<Appointment[]>{
    return this.httpClient.get<Appointment[]>(`${this.baseURL}`);
  }

 createAppointment(appointment: Appointment): Observable<Object>{
   return this.httpClient.post(`${this.baseURL}`, appointment);
  }

  getAppointmentsByUserId(userId: string): Observable<Appointment[]>{
    return this.httpClient.get<Appointment[]>(`${this.baseURL}/userid/${userId}`);
  }
 

  
  getAppointmentById(appointentId: number): Observable<Appointment>{
    return this.httpClient.get<Appointment>(`${this.baseURL}/${appointentId}`);
  }

  updateAppointment(appointmentId: number, appointment: Appointment): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${appointmentId}`, appointment);
  }
 
  deleteAppointment(appointmentId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${appointmentId}`);
  }


  
}