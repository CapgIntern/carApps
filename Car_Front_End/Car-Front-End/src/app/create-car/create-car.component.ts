import { Component, OnInit } from '@angular/core';
import { Mycars} from '../mycars';
import { MycarsService } from '../mycars.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-car',
  templateUrl: './create-car.component.html',
  styleUrls: ['./create-car.component.css']
})
export class CreateCarComponent implements OnInit {

  car: Mycars = new Mycars();
  constructor(private carService: MycarsService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveCar(){
    this.carService.createCar(this.car).subscribe( data =>{
      console.log(data);
      this.goToCarList();
    },
    error => console.log(error));
  }

  goToCarList(){
    this.router.navigate(['./car-list']);
  }
  
  onSubmit(){
    this.car.userId = localStorage.getItem("userId");
    console.log(this.car);
    this.saveCar();
  }
}