import { Component, OnInit } from '@angular/core';
import { Payment} from '../payment';
import { PaymentService } from '../payment.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-payment',
  templateUrl: './create-payment.component.html',
  styleUrls: ['./create-payment.component.css']
})
export class CreatePaymentComponent implements OnInit {

  payment : Payment = new Payment();
  orderId : number;
  userId:string;

  message:string;
  errorMessage:string;
  constructor(private paymentService: PaymentService,
    private router: Router,
    private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.orderId = this.route.snapshot.params['id'];
    this.userId = localStorage.getItem('userId'); 
  }

  savePayment(){
    this.paymentService.createPayment(this.payment).subscribe( data =>{
      console.log(data);
      this.message='Payment Details Added Successfully!!!.';
      this.errorMessage=undefined;
     // this.goToPaymentList();
      
    },
    error => 
      console.log(error));
  }

  goToPaymentList(){
    this.router.navigate(['/payments']);
  }
  
  onSubmit(){
    console.log(this.payment);
    this.payment.orderId = this.orderId;
    this.payment.userId = this.userId;
    this.savePayment();
  }

}