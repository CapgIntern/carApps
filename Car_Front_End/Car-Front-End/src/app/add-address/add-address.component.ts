import { Component, OnInit } from '@angular/core';
import { Address} from '../address';
import { AddressService } from '../address.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css']
})
export class AddAddressComponent implements OnInit {

  address : Address = new Address();
  constructor(private addressService: AddressService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveAddress(){
    this.addressService.addAddress(this.address).subscribe( data =>{
      console.log(data);
      this.goToCustomerList();
    },
    error => console.log(error));
  }

  goToCustomerList(){
    this.router.navigate(['/customer-details']);
    alert("Address Updated Successfully")
  }
  
  onSubmit(){
    this.address.userId = localStorage.getItem("userId");
    console.log(this.address);
    this.saveAddress();
  }

}
