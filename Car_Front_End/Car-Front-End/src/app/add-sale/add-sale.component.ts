import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { Sales } from '../sales';
import { SalesService } from '../sales.service';

@Component({
  selector: 'app-add-sale',
  templateUrl: './add-sale.component.html',
  styleUrls: ['./add-sale.component.css']
})
export class AddSaleComponent implements OnInit {

  sale: Sales = new Sales();
  constructor(private saleService: SalesService, private router: Router) { }

  ngOnInit(): void {
  }

  saveSale(){
    this.saleService.createSale(this.sale).subscribe( data =>{
      console.log(data);
      this.goToMyCarList();
    },
    error => console.log(error));
  }

  goToMyCarList(){
    this.router.navigate(['/car-list']);
    alert("Sale Added succesfully")
  }
  
  onSubmit(){
    console.log(this.sale);
    this.saveSale();
  }
}
