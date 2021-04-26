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
    return this.httpClient.get<Car[]>(`${this.baseURL}`);
  }
  createCar(car: Car): Observable<Object>{
    return this.httpClient.post(`${"http://localhost:8800/addcar"}`, car);
  }

  
  getCarById(carId: number): Observable<Car>{
    return this.httpClient.get<Car>(`${"http://localhost:8800/carsbyid"}/${carId}`);
  }

  updateCar(carId: number, car: Car): Observable<Object>{
    return this.httpClient.put(`${"http://localhost:8800/updatecar"}/${carId}`, car);
  }
 
  deleteCar(carId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${carId}`);
  }


  
}