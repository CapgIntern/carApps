import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Payment } from './payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  

  constructor(private httpClient: HttpClient) { }
  
  getPaymentsList(): Observable<Payment[]>{
    return this.httpClient.get<Payment[]>(`${"http://localhost:8800/getAllPaymentDetails"}`);
  }

  createPayment(payment: Payment): Observable<Object>{
    return this.httpClient.post(`${"http://localhost:8800/addPayment"}`, payment);
  }

  
  getPaymentById(paymentId: number): Observable<Payment>{
    return this.httpClient.get<Payment>(`${"http://localhost:8800/getPaymentDetails"}/${paymentId}`);
  }

  updatePayment(paymentId: number, payment: Payment): Observable<Object>{
    return this.httpClient.put(`${"http://localhost:8800/updatePayment"}/${paymentId}`, payment);
  }
 
  deletePayment(paymentId: number): Observable<Object>{
    return this.httpClient.delete(`${"http://localhost:8800/removePayment"}/${paymentId}`);
  }

}