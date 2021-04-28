import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-details',
  templateUrl: './admin-details.component.html',
  styleUrls: ['./admin-details.component.css']
})
export class AdminDetailsComponent implements OnInit {
  user: any;
  constructor(private router: Router) { }
  ngOnInit(): void {
  }
  LogOutAdmin(){
    this.router.navigate(['login']);
  }

}


