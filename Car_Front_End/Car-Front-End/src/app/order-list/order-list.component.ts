import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class OrderListComponent implements OnInit {
  orders: Order[];
  userId:string;
  msg:string;
  errorMsg:string;

  constructor(private orderService: OrderService, private router: Router, config: NgbModalConfig, private modalService: NgbModal) { 
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit(): void {
    this.getOrders();
    this.userId=localStorage.getItem("userId");
  }

  private getOrders(){
    this.orderService.getOrdersList().subscribe(data => {
      this.orders = data;
    });
  }

  updateOrder(orderId: number){
    this.router.navigate(['update-order', orderId]);
  }

  

  orderDetails(orderId: number){
    this.router.navigate(['order-details', orderId]);
  }
  checkUser(user:string):Boolean{
    if(this.userId===user){
      return true;
    }
    else{
      return false;
    }
  }
  open(content) {
    this.modalService.open(content, { centered: true });
  }
  deleteorder(orderId: number){
    this.orderService.deleteOrder(orderId)
      .subscribe(data=>{
        this.msg=data;
        this.errorMsg=undefined;
        this.orderService.getOrdersList().subscribe(data=>this.orders=data);
        console.log(this.orders);
      },
      error=>{
        this.errorMsg=error.error;
        this.msg=undefined;
    });
  }
   
  }
