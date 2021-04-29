import { Component, OnInit } from '@angular/core';
import { Payment} from '../payment';
import { PaymentService } from '../payment.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-payment',
  templateUrl: './update-payment.component.html',
  styleUrls: ['./update-payment.component.css']
})
export class UpdatePaymentComponent implements OnInit {

  id: number;
  payment: Payment = new Payment();
  message:string;
  errorMessage:string;
  constructor(private paymentService: PaymentService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.paymentService.getPaymentById(this.id).subscribe(data => {
      this.payment = data;
    }, error => console.log(error));
  }

  savePayment(){
    this.paymentService.updatePayment(this .id,this.payment).subscribe( data =>{
      console.log(data);
      this.goToPaymentList();
      this.message='Payment Details Updated Successfully!!!.';
      this.errorMessage=undefined;
    },
    error => console.log(error));
  }


  onSubmit(){
    this.paymentService.updatePayment(this.id, this.payment).subscribe( data =>{
      this.goToPaymentList();
      this.savePayment();
    }
    , error => console.log(error));
  }

  goToPaymentList(){
    this.router.navigate(['/payments']);
  }

}
