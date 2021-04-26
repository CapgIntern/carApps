import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from './car';
@Injectable({
  providedIn: 'root'
})
export class CarService {
  private baseURL = "http://localhost:8800/cars";

  constructor(private httpClient: HttpClient) { }
  
  getCarsList(): Observable<Car[]>{
    return this.httpClient.get<Car[]>(`${this.baseURL}/${"allcars"}`);
  }
  createCar(car: Car): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${"addcar"}`, car);
  }
  
  getCarById(carId: number): Observable<Car>{
    return this.httpClient.get<Car>(`${this.baseURL}/${"carbycarid"}/${carId}`);
  }

  getCarByUserId(userId: number): Observable<Car[]>{
    return this.httpClient.get<Car[]>(`${this.baseURL}/${"carsbyuserid"}/${userId}`);
  }

  updateCar(carId: number, car: Car): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${"updatecar"}/${carId}`, car);
  }

  transferUser(carId: number, userId: string): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${"transferuser"}/${carId}/${userId}`, null);
  }
 
  deleteCar(carId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${"deletecar"}/${carId}`);
  }


  
}