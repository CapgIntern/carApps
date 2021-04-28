import { Component, OnInit } from '@angular/core';
import { Address } from '../address';
import { AddressService } from '../address.service';
import { Router } from '@angular/router';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class AddressDetailsComponent implements OnInit {

  id:string
  addresss: Address[];
  msg: string;
  errorMsg: string;

  constructor(private AddressService: AddressService, private router: Router, config: NgbModalConfig, private modalService: NgbModal) { 
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit(): void {
    this.getAddress();
  }

  private getAddress(){
    this.id = localStorage.getItem("userId");
    this.AddressService.getAddressByUserId(this.id).subscribe(data =>{
      this.addresss = data;
    });
  }

  deleteAddress(addressId: number){
    this.AddressService.deleteAddress(addressId).subscribe( data => {
      console.log(data);
      this.getAddress();
    });
  }

  updateAddress(addressId: number){
    this.router.navigate(['update-address', addressId]);
  }

  open(content) {
    this.modalService.open(content, { centered: true });
  }
}
