import { Component, OnInit } from '@angular/core';
import { Payment} from '../payment';
import { PaymentService } from '../payment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment-list',
  templateUrl: './payment-list.component.html',
  styleUrls: ['./payment-list.component.css']
})
export class PaymentListComponent implements OnInit {

  payments: Payment[];
  message:string;
  errorMessage:string;

  constructor(private paymentService: PaymentService, private router: Router) { }

  ngOnInit(): void {
    this.getPayments();
  }

  private getPayments(){
    this.paymentService.getPaymentsList().subscribe(data => {
      this.payments = data;
    });
  }

  updatePayment(paymentId: number){
    this.router.navigate(['update-payment', paymentId]);
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
        this.paymentService.getPaymentsList().subscribe(data=>this.payments=data);
        console.log(this.payments);
      },
        error=>{
          this.errorMessage=error.error;
          this.message=undefined;
        });
      }
  }
}
