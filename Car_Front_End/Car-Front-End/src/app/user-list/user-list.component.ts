import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  msg:string;
  errorMsg:string;
  user: User[];

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.getUser();
  }

  private getUser(){
    this.userService.getUserList().subscribe(data => {
      this.user = data;
    });
  }

  updateUser(userId: string){
    this.router.navigate(['update-user', userId]);
  }

  

  userDetails(userId: string){
    this.router.navigate(['user-details', userId]);
  } 

  deleteUser(userId: string){
    if(confirm("Confirm Deletion of User Id:"+userId)){
      this.userService.deleteUser(userId)
      .subscribe(data=>{
        this.msg="deleted user succesfully";
        this.errorMsg=undefined;
        this.userService.getUserList().subscribe(data=>this.user=data);
        console.log(this.user);
      },
        error=>{
          this.errorMsg=error.error;
          this.msg=undefined;
        });
    }
  }
}