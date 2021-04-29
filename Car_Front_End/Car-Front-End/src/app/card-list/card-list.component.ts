import { Component, OnInit } from '@angular/core';

import { Card } from '../card';
import { CardService } from '../card.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-card-list',
  templateUrl: './card-list.component.html',
  styleUrls: ['./card-list.component.css'],
  providers: [NgbModalConfig, NgbModal],
})
export class CardListComponent implements OnInit {

  cards: Card[];
  userId: string;
  message:string;
  errorMessage:string;

  constructor(private cardService: CardService, private router: Router,private route: ActivatedRoute,config: NgbModalConfig, private modalService: NgbModal
) {config.backdrop = 'static';
config.keyboard = false; }

  ngOnInit(): void {
    this.userId = localStorage.getItem("userId");
    this.getCards();
  }

  private getCards(){
    this.cardService.getCardByUserId(this.userId).subscribe(data => {
      this.cards = data;
    });
  }

  updateCard(cardId: number){
    this.router.navigate(['update-card', cardId]);
  }

  open(content) {
    this.modalService.open(content, { centered: true });
  }

  cardDetails(cardId: number){
    this.router.navigate(['payment-details', cardId]);
  }

  deleteCard(cardId: number){
      this.cardService.deleteCard(cardId)
      .subscribe(data=>{
        this.errorMessage=undefined;
        this.cardService.getCardByUserId(this.userId).subscribe(data=>this.cards=data);
        console.log(this.cards);
      },
        error=>{
          this.errorMessage=error.error;
          this.message=undefined;
        });
  }

}
