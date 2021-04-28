import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  id: string;
  customer: Customer = new Customer();
  constructor(private customerService: CustomerService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = localStorage.getItem("userId");

    this.customerService.getCustomerById(this.id).subscribe(data => {
      this.customer = data;
    }, error => console.log(error));
  }

  saveCustomer(){
    this.customerService.updateCustomer(this.id,this.customer).subscribe( data =>{
      console.log(data);
      this.goToCustomerList();
    },
    error => console.log(error));
  }


  onSubmit(){
    this.customerService.updateCustomer(this.id, this.customer).subscribe( data =>{
      this.saveCustomer();
    }
    , error => console.log(error));
  }

  goToCustomerList(){
    this.router.navigate(['/customer-details']);
    alert("Details Updated Successfully")
  }
}