import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Card } from '../card';
import { CardService } from '../card.service';

@Component({
  selector: 'app-update-card',
  templateUrl: './update-card.component.html',
  styleUrls: ['./update-card.component.css']
})
export class UpdateCardComponent implements OnInit {

  id: number;
  card: Card = new Card();
  message:string;
  errorMessage:string;
  constructor(private cardService: CardService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.cardService.getCardById(this.id).subscribe(data => {
      this.card = data;
    }, error => console.log(error));
  }

  saveCard(){
    this.cardService.addCard(this.card).subscribe( data =>{
      console.log(data);
      this.goToAppointmentList();
      this.message='Card Updated Added Successfully!!!.';
      this.errorMessage=undefined;
    },
    error => console.log(error));
  }


  onSubmit(){
    this.cardService.updateCard(this.id, this.card).subscribe( data =>{
      //this.goToAppointmentList();
      this.saveCard();
    }
    , error => console.log(error));
  }

  goToAppointmentList(){
    alert("card updated sucessfully");
    this.router.navigate(['/customer-details']);
  }

}
