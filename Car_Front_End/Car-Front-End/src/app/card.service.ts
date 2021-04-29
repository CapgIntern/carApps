import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Card } from './card';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  //private baseURL = "http://localhost:8800/payments";

  constructor(private httpClient: HttpClient) { }
  
  getCardByUserId(userId:string): Observable<Card[]>{
    return this.httpClient.get<Card[]>(`${"http://localhost:8800/cardbyuserid"}/${userId}`);
  }

  getCardById(cardId:number): Observable<Card>{
    return this.httpClient.get<Card>(`${"http://localhost:8800/cardbyid"}/${cardId}`);
  }

  addCard(card: Card): Observable<Object>{
    return this.httpClient.post(`${"http://localhost:8800/addcard"}`, card);
  }

  updateCard(cardId: number, card: Card): Observable<Object>{
    return this.httpClient.put(`${"http://localhost:8800/updatecard"}/${cardId}`, card);
  }
 
  deleteCard(cardId: number): Observable<Object>{
    return this.httpClient.delete(`${"http://localhost:8800/card"}/${cardId}`);
  }
}
