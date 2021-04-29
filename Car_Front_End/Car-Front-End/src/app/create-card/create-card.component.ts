import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Card } from '../card';
import { CardService } from '../card.service';

@Component({
  selector: 'app-create-card',
  templateUrl: './create-card.component.html',
  styleUrls: ['./create-card.component.css']
})
export class CreateCardComponent implements OnInit {

  card : Card = new Card();
  
  message:string;
  errorMessage:string;
  constructor(private cardService: CardService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveCard(){
    this.card.userId = localStorage.getItem("userId");
    this.cardService.addCard(this.card).subscribe( data =>{
      console.log(data);
      this.errorMessage=undefined;
      this.goToPaymentList();
      
    },
    error => 
      console.log(error));
      alert('Card Details Added Successfully!!!.');
  }

  goToPaymentList(){
    this.router.navigate(['/customer-details']);
  }
  
  onSubmit(){
    console.log(this.card);
    this.saveCard();
  }

}
