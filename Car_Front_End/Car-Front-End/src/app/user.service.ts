import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
@Injectable({
  providedIn: 'root'
}) 
export class UserService {

  private baseURL = "http://localhost:8800/getallusers";

  constructor(private httpClient: HttpClient) { }
  
  getUserList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}`);
  }
 
  createUser(user: User): Observable<any>{
    return this.httpClient.post(`${"http://localhost:8800/addUser"}`, user);
  }

  
  getUserById(userId: string): Observable<User>{
    return this.httpClient.get<User>(`${"http://localhost:8800/getuserbyid"}/${userId}`);
  }

  updateUser(userId: string, password:string): Observable<Object>{
    return this.httpClient.put(`${"http://localhost:8800/updatepassword"}/${userId}/${password}`,{responseType:"text"});
  }
 
  deleteUser(userId: string): Observable<Object>{
    return this.httpClient.delete(`${"http://localhost:8800/user"}/${userId}`);
  }

  loginUser(user:User): Observable<Object>{
    return this.httpClient.post(`${"http://localhost:8800/login"}`,user);
  }
   
  logoutUser(user:User): Observable<Object>{
    return this.httpClient.post(`${"http://localhost:8800/logout"}`,user);
  }
}