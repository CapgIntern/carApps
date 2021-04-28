import { Component, OnInit } from '@angular/core';
import { User} from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
  user : User = new User();
  msg:string;
  errorMsg:string;
  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
  }
 
  saveUser(){
    this.userService.createUser(this.user).subscribe( data =>{
      console.log(data);
      this.msg="user added succesfully";
      this.errorMsg=undefined;
      //this.goToUserList();
    },
    (error)=>
    {
      this.errorMsg=error.error;
      console.log(error.error);
      this.msg=undefined
    });
  }
  goToUserList(){
    this.router.navigate(['/login']);
  }
  onSubmit(){
    console.log(this.user);
    this.saveUser();
  }
  signUpUser(){
    this.router.navigate(['/login']);
  }
  
}
