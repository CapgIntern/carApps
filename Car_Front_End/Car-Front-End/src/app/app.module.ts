import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { FormsModule} from '@angular/forms';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { UpdateAppointmentComponent } from './update-appointment/update-appointment.component';
import { AppointmentDetailsComponent } from './appointment-details/appointment-details.component';
import { HomeCarappComponent } from './home-carapp/home-carapp.component';
import { CarListComponent } from './car-list/car-list.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { UpdateCarComponent } from './update-car/update-car.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { PaymentListComponent } from './payment-list/payment-list.component';
import { PaymentDetailsComponent } from './payment-details/payment-details.component';
import { CreatePaymentComponent } from './create-payment/create-payment.component';
import { UpdatePaymentComponent } from './update-payment/update-payment.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
@NgModule({
  declarations: [
    AppComponent,
    AppointmentListComponent,
    CreateAppointmentComponent,
    UpdateAppointmentComponent,
    AppointmentDetailsComponent,
    HomeCarappComponent,
    CarListComponent,
    CarDetailsComponent,
    CreateCarComponent,
    UpdateCarComponent,
    UpdateCustomerComponent,
    CreateCustomerComponent,
    CustomerDetailsComponent,
    CustomerListComponent,
    UserListComponent,
    UserDetailsComponent,
    CreateUserComponent,
    UpdateUserComponent,
    PaymentListComponent,
    PaymentDetailsComponent,
    CreatePaymentComponent,
    UpdatePaymentComponent,
    OrderListComponent,
    OrderDetailsComponent,
    CreateOrderComponent,
    UpdateOrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
