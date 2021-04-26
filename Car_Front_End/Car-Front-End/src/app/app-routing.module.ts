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

const routes: Routes = [
  {path: 'appointments', component: AppointmentListComponent},
  {path: 'car-list/add-appointments', component: CreateAppointmentComponent},
  {path: '',component:CarListComponent},
  {path: 'update-appointment/:id', component: UpdateAppointmentComponent},
  {path: 'appointment-details/:id', component: AppointmentDetailsComponent},
  {path: 'car-list', component:HomeCarappComponent},
  {path: 'add-cars', component: CreateCarComponent},
  {path: 'update-car/:id', component: UpdateCarComponent},
  {path: 'car-details/:id', component: CarDetailsComponent},
  {path: 'customer-details', component: CustomerDetailsComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[AppointmentListComponent,CreateAppointmentComponent]