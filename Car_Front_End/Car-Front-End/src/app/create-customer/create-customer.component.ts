import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  customer : Customer = new Customer();
  msg:String;
  errorMsg:String;
  constructor(private customerService: CustomerService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }
  saveCustomer(){
    this.customerService.createCustomer(this.customer).subscribe( data =>{
      console.log(data);
      this.msg=data;
      this.errorMsg=undefined;
      this.goToCustomerList();
    },
    (error)=>
    {
      this.errorMsg=error.error;
      console.log(error.error);
      this.msg=undefined
    });
  }
  goToCustomerList(){
    this.router.navigate(['/customers']);
    alert("customer details added")
  }
  onSubmit(){
    console.log(this.customer);
    this.saveCustomer();
  }
}
