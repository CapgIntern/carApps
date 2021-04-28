import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { registerLocaleData } from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg:string;
  errorMsg:string;
  user : User = new User();
  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
  }
  LoginUser(){
    this.userService.loginUser(this.user).subscribe(data=>{
      if (this.user.role=="admin"){
        this.router.navigate(['admindetails', this.user.userId]); 
      }
      else{
        this.login();
        this.router.navigate(['./car-list']);
      }
    },
    (error)=>
    {
      this.errorMsg="invalid";
      
      this.msg=undefined
    });
  }
registerUser(){
  this.router.navigate(['add-user']);
}
login(){
  //assuming loin is successful and got user object.
  
localStorage.setItem('userId',this.user.userId);
localStorage.setItem("loginCheck", "true");

}
logOut(){
  this.user=undefined;
  localStorage.removeItem('userId');
  localStorage.setItem("loginCheck", "false");
}
}
