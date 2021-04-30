import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-all-orders',
  templateUrl: './all-orders.component.html',
  styleUrls: ['./all-orders.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class AllOrdersComponent implements OnInit {

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


}
