import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../customer';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  id:string
   customer : Customer
  constructor(private route: ActivatedRoute, private router: Router, private customerService: CustomerService) { }
  
  ngOnInit(): void {


    this.getCustomer();
  }

  private getCustomer(){
    // this.id= this.route.snapshot.params['id'];
    this.id = localStorage.getItem("userId");
    this.customer = new Customer();
    this.customerService.getCustomerById(this.id).subscribe( data => {
      this.customer = data;
    });
  }

  updateCustomer(userId: string){
    this.router.navigate(['update-customer', userId]);
  }

}
