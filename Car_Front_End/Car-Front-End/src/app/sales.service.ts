import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sales } from './sales';
import { Mycars } from './mycars';

@Injectable({
  providedIn: 'root'
})
export class SalesService {
  private baseURL = "http://localhost:8800/sale";

  constructor(private httpClient: HttpClient) { }
 
  getCarOnSale(): Observable<Mycars[]>{
    return this.httpClient.get<Mycars[]>(`${this.baseURL}/${"onsale"}`);
  }
  getSaleByCarId(carId: number): Observable<Sales>{
    return this.httpClient.get<Sales>(`${this.baseURL}/${"salebycarid"}/${carId}`);
  }

  createSale(sale: Sales): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${"addsale"}`, sale);
  }
}
