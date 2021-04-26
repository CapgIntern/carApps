import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[];
  msg:string;
  errorMsg:string;
  constructor(private customerService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    this.getCustomers();
  }

  private getCustomers(){
    this.customerService.getCustomersList().subscribe(data => {
      this.customers = data;
    });
  }

  updateCustomer(userId: string){
    this.router.navigate(['update-customer', userId]);
  }

  

  customerDetails(userId: string){
    this.router.navigate(['customer-details', userId]);
  }

  deleteCustomer(userId: string){
    if(confirm("Confirm Deletion of Customer Id:"+userId)){
      this.customerService.deleteCustomer(userId)
      .subscribe(data=>{
        this.msg=data;
        this.errorMsg=undefined;
        this.customerService.getCustomersList().subscribe(data=>this.customers=data);
        console.log(this.customers);
      },
        error=>{
          this.errorMsg=error.error;
          this.msg=undefined;
        });
    }
  }
  }
