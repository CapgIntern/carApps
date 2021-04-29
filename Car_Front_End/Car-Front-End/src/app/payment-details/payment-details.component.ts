import { Component, OnInit } from '@angular/core';
import { Payment} from '../payment';
import { PaymentService } from '../payment.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-payment-details',
  templateUrl: './payment-details.component.html',
  styleUrls: ['./payment-details.component.css']
})
export class PaymentDetailsComponent implements OnInit {  

  id:number
   payment : Payment
  constructor(private route: ActivatedRoute, private paymentService: PaymentService) { }
  
  ngOnInit(): void {

    this.getPayment();
  }

  private getPayment(){
    this.id= this.route.snapshot.params['id'];

    this.payment = new Payment();
    this.paymentService.getPaymentById(this.id).subscribe( data => {
      this.payment = data;
    });
  }

}
