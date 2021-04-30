import { Injectable } from '@angular/core';
import {  CanActivate, Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate {

  constructor(public router:Router) {

   }
  canActivate(): boolean  {
  
    if(localStorage.getItem('userId'))//if login success
    {
      return true;
    }
    else{
      this.router.navigate(['error']);
      return false;
    }
  }
}