import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Address } from './address';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private baseURL = "http://localhost:8800/address";

  constructor(private httpClient: HttpClient) { }
  

  addAddress(address : Address): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${"addaddress"}`, address);
  }

  getAddressByUserId(userId: string): Observable<Address[]>{
    return this.httpClient.get<Address[]>(`${this.baseURL}/${"addressbyuserid"}/${userId}`);
  }

  updateAddress(addressId: number, address: Address): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${"updateaddress"}/${addressId}`, address);
  }
 
  deleteAddress(addressId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${"address"}/${addressId}`);
  }
}
