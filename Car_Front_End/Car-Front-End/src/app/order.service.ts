import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseURL = "http://localhost:8800/o1";

  constructor(private httpClient: HttpClient) { }
  
  getOrdersList(): Observable<Order[]>{
    return this.httpClient.get<Order[]>(`${this.baseURL}/allOrders`);
  }
  createOrder(order: Order): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/addorder`, order);
  }

  
  getOrderById(orderId: number): Observable<Order>{
    return this.httpClient.get<Order>(`${this.baseURL}/order/${orderId}`);
  }

  updateOrder(orderId: number, order: Order): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/updateorder/${orderId}`, order);
  }
 
  deleteOrder(orderId: number): Observable<any>{
    return this.httpClient.delete(`${this.baseURL}/deleteorder/${orderId}`);
  }
}
