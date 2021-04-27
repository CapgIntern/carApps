import { Component, OnInit } from '@angular/core';
import { Address } from '../address';
import { AddressService } from '../address.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css']
})
export class AddressDetailsComponent implements OnInit {

  id:string
  addresss: Address[];
  msg: string;
  errorMsg: string;

  constructor(private AddressService: AddressService, private router: Router) { }

  ngOnInit(): void {
    this.getAddress();
  }

  private getAddress(){
    this.id = "raju007";
    this.AddressService.getAddressByUserId(this.id).subscribe(data =>{
      this.addresss = data;
    });
  }
}
