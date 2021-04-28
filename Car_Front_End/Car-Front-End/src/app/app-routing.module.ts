import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { UpdateAppointmentComponent } from './update-appointment/update-appointment.component';
import { AppointmentDetailsComponent} from './appointment-details/appointment-details.component';
import { HomeCarappComponent } from './home-carapp/home-carapp.component';
import { CarListComponent } from './car-list/car-list.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { UpdateCarComponent } from './update-car/update-car.component';
import { CarDetailsComponent} from './car-details/car-details.component';
import { CustomerDetailsComponent} from './customer-details/customer-details.component';
import { AddressDetailsComponent } from './address-details/address-details.component';
import { UpdateCustomerComponent} from './update-customer/update-customer.component';
import { MycarsDetailsComponent } from './mycars-details/mycars-details.component';
import { SaleDetailsComponent } from './sale-details/sale-details.component';
import { AddAddressComponent } from './add-address/add-address.component';
import { UpdateAddressComponent } from './update-address/update-address.component';
import { AddSaleComponent } from './add-sale/add-sale.component';

const routes: Routes = [
  {path: 'appointments', component: AppointmentListComponent},
  {path: 'sale-details/add-appointments', component: CreateAppointmentComponent},
  {path: '',component:CarListComponent},
  {path: 'update-appointment/:id', component: UpdateAppointmentComponent},
  {path: 'appointment-details/:id', component: AppointmentDetailsComponent},
  {path: 'car-list', component:MycarsDetailsComponent},
  {path: 'car-list/add-cars', component: CreateCarComponent},
  {path: 'update-car/:id', component: UpdateCarComponent},
  {path: 'car-details/:id', component: CarDetailsComponent},
  {path: 'customer-details', component: CustomerDetailsComponent},
  {path: 'address-details', component: AddressDetailsComponent},
  {path: 'update-customer/:id', component: UpdateCustomerComponent},
  {path: 'sale-details', component: SaleDetailsComponent},
  {path: 'customer-details/add-address', component: AddAddressComponent},
  {path: 'update-address/:id', component: UpdateAddressComponent},
  {path: 'car-list/add-sale', component: AddSaleComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[AppointmentListComponent,CreateAppointmentComponent]