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
  {path: 'users', component:UserListComponent},
  {path: 'add-user', component: CreateUserComponent},
  {path: 'update-user/:id', component: UpdateUserComponent},
  {path: 'user-details/:id', component: UserDetailsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logindetails/:id', component:LoginDetailsComponent},
  {path: 'admindetails/:id', component:AdminDetailsComponent},
  {path: 'add-orders/:appid', component: CreateOrderComponent},
  {path: 'orders', component: OrderListComponent},
  {path: 'order-details/:id', component: OrderDetailsComponent},
  {path: 'update-order/:id', component: UpdateOrderComponent},
  {path: 'payments', component: PaymentListComponent},
  {path: 'add-payments/:id', component: CreatePaymentComponent},
  {path: 'update-payment/:id', component: UpdatePaymentComponent},
  {path: 'payment-details/:id', component: PaymentDetailsComponent},
  {path: 'cards', component: CardListComponent},
  {path: 'customer-details/add-cards', component: CreateCardComponent},
  {path: 'update-card/:id', component: UpdateCardComponent},
  {path: 'card-details/:id', component: CardDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[AppointmentListComponent,CreateAppointmentComponent]