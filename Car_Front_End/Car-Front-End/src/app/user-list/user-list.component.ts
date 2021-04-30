import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class UserListComponent implements OnInit {
  msg:string;
  errorMsg:string;
  user: User[];

  constructor(private userService: UserService,config: NgbModalConfig, private modalService: NgbModal,private router: Router) {
    config.backdrop = 'static';
    config.keyboard = false;
   }

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
  open(content) {
    this.modalService.open(content, { centered: true });
  }
}