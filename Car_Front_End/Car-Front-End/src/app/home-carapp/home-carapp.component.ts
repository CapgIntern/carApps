import { Component, OnInit } from '@angular/core';
import { Car} from '../car';
import { CarService } from '../car.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home-carapp',
  templateUrl: './home-carapp.component.html',
  styleUrls: ['./home-carapp.component.css']
})
export class HomeCarappComponent implements OnInit {
  cars: Car[];

  constructor(private carService: CarService, private router: Router) { }

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

  

  

  

  
}