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
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDetailsComponent} from './user-details/user-details.component';
import { LoginComponent} from './login/login.component';
import { LoginDetailsComponent } from './login-details/login-details.component';
import { AdminDetailsComponent } from './admin-details/admin-details.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { OrderListComponent } from './order-list/order-list.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { CardDetailsComponent } from './card-details/card-details.component';
import { CardListComponent } from './card-list/card-list.component';
import { CreateCardComponent } from './create-card/create-card.component';
import { CreatePaymentComponent } from './create-payment/create-payment.component';
import { PaymentDetailsComponent } from './payment-details/payment-details.component';
import { PaymentListComponent } from './payment-list/payment-list.component';
import { UpdateCardComponent } from './update-card/update-card.component';
import { UpdatePaymentComponent } from './update-payment/update-payment.component';
import { CommonModule } from '@angular/common';
import {AuthService as AuthGuard} from './auth.service';
import { ErrorComponent } from './error/error.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { AppointmentAllComponent} from './appointment-all/appointment-all.component';
import { AllPaymentsComponent } from './all-payments/all-payments.component';
import { AllOrdersComponent } from './all-orders/all-orders.component';


const routes: Routes = [
  {path: 'appointments', component: AppointmentListComponent,canActivate:[AuthGuard]},
  {path: 'sale-details/add-appointments', component: CreateAppointmentComponent,canActivate:[AuthGuard]},
  {path: '',component:CarListComponent},
  {path: 'update-appointment/:id', component: UpdateAppointmentComponent,canActivate:[AuthGuard]},
  {path: 'appointment-details/:id', component: AppointmentDetailsComponent,canActivate:[AuthGuard]},
  {path: 'car-list', component:MycarsDetailsComponent,canActivate:[AuthGuard]},
  {path: 'car-list/add-cars', component: CreateCarComponent,canActivate:[AuthGuard]},
  {path: 'update-car/:id', component: UpdateCarComponent,canActivate:[AuthGuard]},
  {path: 'car-details/:id', component: CarDetailsComponent,canActivate:[AuthGuard]},
  {path: 'customer-details', component: CustomerDetailsComponent,canActivate:[AuthGuard]},
  {path: 'address-details', component: AddressDetailsComponent,canActivate:[AuthGuard]},
  {path: 'update-customer/:id', component: UpdateCustomerComponent,canActivate:[AuthGuard]},
  {path: 'sale-details', component: SaleDetailsComponent,canActivate:[AuthGuard]},
  {path: 'customer-details/add-address', component: AddAddressComponent,canActivate:[AuthGuard]},
  {path: 'update-address/:id', component: UpdateAddressComponent,canActivate:[AuthGuard]},
  {path: 'car-list/add-sale', component: AddSaleComponent,canActivate:[AuthGuard]},
  {path: 'users', component:UserListComponent,canActivate:[AuthGuard]},
  {path: 'add-user', component: CreateUserComponent},
  {path: 'update-user/:id', component: UpdateUserComponent,canActivate:[AuthGuard]},
  {path: 'user-details/:id', component: UserDetailsComponent,canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'logindetails/:id', component:LoginDetailsComponent,canActivate:[AuthGuard]},
  {path: 'admindetails/:id', component:AdminDetailsComponent,canActivate:[AuthGuard]},
  {path: 'add-orders/:appid', component: CreateOrderComponent,canActivate:[AuthGuard]},
  {path: 'orders', component: OrderListComponent,canActivate:[AuthGuard]},
  {path: 'order-details/:id', component: OrderDetailsComponent,canActivate:[AuthGuard]},
  {path: 'update-order/:id', component: UpdateOrderComponent,canActivate:[AuthGuard]},
  {path: 'payments', component: PaymentListComponent,canActivate:[AuthGuard]},
  {path: 'add-payments/:id', component: CreatePaymentComponent,canActivate:[AuthGuard]},
  {path: 'update-payment/:id', component: UpdatePaymentComponent,canActivate:[AuthGuard]},
  {path: 'payment-details/:id', component: PaymentDetailsComponent,canActivate:[AuthGuard]},
  {path: 'cards', component: CardListComponent,canActivate:[AuthGuard]},
  {path: 'customer-details/add-cards', component: CreateCardComponent,canActivate:[AuthGuard]},
  {path: 'update-card/:id', component: UpdateCardComponent,canActivate:[AuthGuard]},
  {path: 'card-details/:id', component: CardDetailsComponent,canActivate:[AuthGuard]},
  {path:'error',component:ErrorComponent},
  {path: 'customer-list', component: CustomerListComponent,canActivate:[AuthGuard]},
  {path: 'appointments-all', component: AppointmentAllComponent,canActivate:[AuthGuard]},
  {path: 'all-orders', component: AllOrdersComponent,canActivate:[AuthGuard]},
  {path: 'all-payments', component: AllPaymentsComponent,canActivate:[AuthGuard]},


];

@NgModule({
  imports: [RouterModule.forRoot(routes),CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[AppointmentListComponent,CreateAppointmentComponent]