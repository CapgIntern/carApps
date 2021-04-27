import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Mycars } from './mycars';

@Injectable({
  providedIn: 'root'
})
export class MycarsService {

  private baseURL = "http://localhost:8800/cars";

  constructor(private httpClient: HttpClient) { }

  createCar(mycars: Mycars): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${"addcar"}`, mycars);
  }
  
  getCarById(carId: number): Observable<Mycars>{
    return this.httpClient.get<Mycars>(`${this.baseURL}/${"carbycarid"}/${carId}`);
  }

  getCarByUserId(userId: string): Observable<Mycars[]>{
    return this.httpClient.get<Mycars[]>(`${this.baseURL}/${"carsbyuserid"}/${userId}`);
  }

  updateCar(carId: number, mycars: Mycars): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${"updatecar"}/${carId}`, mycars);
  }

  transferUser(carId: number, userId: string): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${"transferuser"}/${carId}/${userId}`, null);
  }
 
  deleteCar(carId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${"deletecar"}/${carId}`);
  }


  
}
