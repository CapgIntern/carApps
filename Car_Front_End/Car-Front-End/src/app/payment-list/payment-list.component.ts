import { Component, OnInit } from '@angular/core';
import { Payment} from '../payment';
import { PaymentService } from '../payment.service';
import { Router } from '@angular/router';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-payment-list',
  templateUrl: './payment-list.component.html',
  styleUrls: ['./payment-list.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class PaymentListComponent implements OnInit {

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
    this.paymentService.getPaymentsByUserId(this.userId).subscribe(data => {
      this.payments = data;
    });
  }

  updatePayment(paymentId: number){
    this.router.navigate(['update-payment', paymentId]);
  }

  checkUser(user:string):Boolean{
    if(this.userId===user){
      return true;
    }
    else{
      return false;
    }
  }

  paymentDetails(paymentId: number){
    this.router.navigate(['payment-details', paymentId]);
  }

  deletePayment(paymentId: number){
    if(confirm("Confirm Deletion of Appointment Id:"+paymentId)){
      this.paymentService.deletePayment(paymentId)
      .subscribe(data=>{
        this.message="ftjdfghjftd";
        this.errorMessage=undefined;
        console.log(this.payments);
      },
        error=>{
          this.errorMessage=error.error;
          this.message=undefined;
        });
      }
  }

  open(content) {
    this.modalService.open(content, { centered: true });
  }
}
