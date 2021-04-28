import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-details',
  templateUrl: './login-details.component.html',
  styleUrls: ['./login-details.component.css']
})
export class LoginDetailsComponent implements OnInit {
  user: any;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  LogOutUser(){
    this.user=undefined;
    localStorage.removeItem('userId');
    this.router.navigate(['login']);
  }
  
}
