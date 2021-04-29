import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  userId: string;
  password:string;
  user: User = new User();
  constructor(private userService: UserService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['id'];
    this.password=this.route.snapshot.params['password'];

    this.userService.getUserById(this.userId).subscribe(data => {
      this.user = data;
    }, error => console.log(error));
    this.password=this.user.password;
  }

  saveUser(){
    this.userService.createUser(this.user).subscribe( data =>{
      console.log(data);
      this.goToUserList();
    },
    error => console.log(error));
  }


  onSubmit(){
    this.userService.updateUser(this.userId, this.password).subscribe( data =>{
      this.goToUserList();
      this.saveUser();
    }
    , error => console.log(error));
  }

  goToUserList(){
    this.router.navigate(['/customer-details']);
  }
}