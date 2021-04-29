import { Component, OnInit } from '@angular/core';
import { Mycars} from '../mycars';
import { Search} from '../search';
import { Router, ActivatedRoute } from '@angular/router';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Sales } from '../sales';
import { MycarsService } from '../mycars.service';
import { SalesService } from '../sales.service';

@Component({
  selector: 'app-sale-details',
  templateUrl: './sale-details.component.html',
  styleUrls: ['./sale-details.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class SaleDetailsComponent implements OnInit {

  carId:number
  sale : Sales;
  filter: Search = new Search();
  mycar : Mycars[];
  constructor(private salesService: SalesService, private route: ActivatedRoute, private carService: MycarsService, private router: Router, config: NgbModalConfig, private modalService: NgbModal) {
    config.backdrop = 'static';
    config.keyboard = false;
   }

  ngOnInit(): void {
    this.getOnSaleCars();
  }


  viewAll(){
    this.getOnSaleCars();
  }

  private getOnSaleCars(){
    this.salesService.getCarOnSale().subscribe(data => {
      this.mycar = data;
    });
  }

  getSale(carid: number){
    this.salesService.getSaleByCarId(carid).subscribe(data => {
      this.sale = data;
    });
  }

  open(content) {
    this.modalService.open(content, { centered: true });
  }
  setCarId(id : number){
    localStorage.setItem("carId", JSON.stringify(id));
  }

  onSubmit(){
    if(this.filter.filterType === "Model"){
      this.carService.getCarByModel(this.filter.filterValue).subscribe(data => {
        this.mycar = data;
      });
    }
    if(this.filter.filterType === "Brand"){
      this.carService.getCarByBrand(this.filter.filterValue).subscribe(data => {
        this.mycar = data;
      });
    }

  }
}
