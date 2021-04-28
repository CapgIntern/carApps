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
  logOut(){
    localStorage.removeItem('userId');
    localStorage.setItem("loginCheck", "false");
    alert("You have logged out succesfully")
  }
}
