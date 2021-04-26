import { Component, OnInit } from '@angular/core';
import { Car} from '../car';
import { CarService } from '../car.service';
import { Router } from '@angular/router';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-home-carapp',
  templateUrl: './home-carapp.component.html',
  styleUrls: ['./home-carapp.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class HomeCarappComponent implements OnInit {
  cars: Car[];

  constructor(private carService: CarService, private router: Router, config: NgbModalConfig, private modalService: NgbModal) {
    config.backdrop = 'static';
    config.keyboard = false;
   }

  ngOnInit(): void {
    this.getCars();
  }

  private getCars(){
    this.carService.getCarsList().subscribe(data => {
      this.cars = data;
    });
  }

  updateCar(carId: number){
    this.router.navigate(['update-car', carId]);
  }



  carDetails(carId: number){
    this.router.navigate(['car-details', carId]);
  }

  deleteCar(carId: number){
    this.carService.deleteCar(carId).subscribe( data => {
      console.log(data);
      this.getCars();
    })
  }

  open(content) {
    this.modalService.open(content, { centered: true });
  }

  

  

  

  
}