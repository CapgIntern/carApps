import { Component, OnInit } from '@angular/core';
import { Address} from '../address';
import { AddressService } from '../address.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-address',
  templateUrl: './update-address.component.html',
  styleUrls: ['./update-address.component.css']
})
export class UpdateAddressComponent implements OnInit {

  id: number;
  address : Address = new Address();
  constructor(private addressService: AddressService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.addressService.getAddressById(this.id).subscribe(data => {
      this.address = data;
    }, error => console.log(error));
  }

  saveAddress(){
    this.addressService.addAddress(this.address).subscribe( data =>{
      console.log(data);
      this.goToCustomerList();
    },
    error => console.log(error));
  }


  onSubmit(){
    this.addressService.updateAddress(this.id, this.address).subscribe( data =>{
      this.goToCustomerList;
      this.saveAddress();
    }
    , error => console.log(error));
  }

  goToCustomerList(){
    this.router.navigate(['/customer-details']);
    alert("Address Updated Successfully")
  }
}
