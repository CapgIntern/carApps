import { Component, OnInit } from '@angular/core';
import { Mycars} from '../mycars';
import { MycarsService } from '../mycars.service';
import { Sales } from '../sales';
import { SalesService } from '../sales.service';
import { Router } from '@angular/router';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-mycars-details',
  templateUrl: './mycars-details.component.html',
  styleUrls: ['./mycars-details.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class MycarsDetailsComponent implements OnInit {

  cars: Mycars[];
  sale: Sales;
  userId: string;
  onSale: Boolean;
  message:string;
  constructor(private salesService: SalesService, private carService: MycarsService, private router: Router, config: NgbModalConfig, private modalService: NgbModal) {
    config.backdrop = 'static';
    config.keyboard = false;
   }

  ngOnInit(): void {
    this.userId = localStorage.getItem("userId");
    this.getCarsByUserId(this.userId);  
  }

  private getCarsByUserId(userId: string){
    this.carService.getCarByUserId(this.userId).subscribe(data => {
      this.cars = data;
    });
  }



  updateCar(carId: number){
    this.router.navigate(['update-car', carId]);
  }

  deleteCar(carId: number){
    this.carService.deleteCar(carId).subscribe( data => {
      console.log(data);
      this.message = "Car deleted Sucessfully"
      this.getCarsByUserId(this.userId);
    });
  }

  open(content) {
    this.modalService.open(content, { centered: true });
  }

  getSale(content, carid: number){
    this.salesService.getSaleByCarId(carid).subscribe(data => {
      this.sale = data;
    });
    this.open(content);
  }

  deleteSale(saleId: number){
    this.salesService.deleteSale(saleId).subscribe( data => {
      console.log(data);
      this.message = "Sale Removed Sucessfully"
      this.getCarsByUserId(this.userId);
    });
  }

  function1() : Boolean{
    return true;
  }

  getColour() : string{
    return 'gold';
  }

  setCarId(id : number){
    localStorage.setItem("carId", JSON.stringify(id));
  }



}
