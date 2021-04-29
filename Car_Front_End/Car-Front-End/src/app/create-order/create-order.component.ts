import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {
  order : Order = new Order();
  userId:string;
  appointmentId: number;
  constructor(private orderService: OrderService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.appointmentId = this.route.snapshot.params['appid'];
    this.userId=localStorage.getItem("userId")

  }

  saveOrder(){
    this.order.userId=this.userId;
    this.order.appointmentId=this.appointmentId;
    this.orderService.createOrder(this.order).subscribe( data =>{
      console.log(data);
      this.goToOrderList();
    },
    error => console.log(error));
  }

  goToOrderList(){
    this.router.navigate(['/orders']);
    alert("Order Added")
  }
  
  onSubmit(){
    console.log(this.order);
    this.saveOrder();

  }
}
