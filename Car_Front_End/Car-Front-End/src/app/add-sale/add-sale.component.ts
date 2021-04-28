import { Component, OnInit } from '@angular/core';
import { Sales } from '../sales';
import { SalesService } from '../sales.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-sale',
  templateUrl: './add-sale.component.html',
  styleUrls: ['./add-sale.component.css']
})
export class AddSaleComponent implements OnInit {

  userId: string;
  carId: number;

  sale: Sales = new Sales();
  constructor(private salesService: SalesService,
    private router: Router) { }

  ngOnInit(): void {
    this.userId = localStorage.getItem("userId");
    this.carId = +localStorage.getItem("carId");
  }

  saveCar(){
    this.salesService.createSale(this.sale).subscribe( data =>{
      console.log(data);
      this.goToCarList();
    },
    error => console.log(error));
  }

  goToCarList(){
    this.router.navigate(['./car-list']);
  }
  
  onSubmit(){
    this.sale.userId = this.userId;
    this.sale.carId = this.carId;
    console.log(this.sale);
    this.saveCar();
  }

}
