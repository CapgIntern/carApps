import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Payment } from '../payment';
import { PaymentService } from '../payment.service';

@Component({
  selector: 'app-all-payments',
  templateUrl: './all-payments.component.html',
  styleUrls: ['./all-payments.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class AllPaymentsComponent implements OnInit {

  payments: Payment[];
  message:string;
  errorMessage:string;
  userId: string;

  constructor(private paymentService: PaymentService, private router: Router, config: NgbModalConfig, private modalService: NgbModal) {
    config.backdrop = 'static';
    config.keyboard = false;
   }

  ngOnInit(): void {
    this.userId = localStorage.getItem('userId');
    this.getPayments();
  }

  private getPayments(){
    this.paymentService.getPaymentsList().subscribe(data => {
      this.payments = data;
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
