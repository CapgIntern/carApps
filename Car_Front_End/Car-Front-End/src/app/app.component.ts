import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CarApp';
  checkUser(): Boolean{
    return JSON.parse(localStorage.getItem("loginCheck"));
  }
  checkAdmin(): Boolean{
    return JSON.parse(localStorage.getItem("adminCheck"));
  }
  checkStatus():Boolean{
    return (this.checkAdmin()||this.checkUser());
  }
  logOut(){
    localStorage.clear();
    localStorage.setItem("loginCheck", "false");
    localStorage.setItem("adminCheck", "false");
    alert("You have logged out succesfully")
  }
}
