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
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddressDetailsComponent } from './address-details/address-details.component';
import { MycarsDetailsComponent } from './mycars-details/mycars-details.component';
import { SaleDetailsComponent } from './sale-details/sale-details.component';
import { AddAddressComponent } from './add-address/add-address.component';
import { UpdateAddressComponent } from './update-address/update-address.component';
import { AddSaleComponent } from './add-sale/add-sale.component';
import { LoginComponent } from './login/login.component';
import { LoginDetailsComponent } from './login-details/login-details.component';
import { AdminDetailsComponent } from './admin-details/admin-details.component';
import { CardDetailsComponent } from './card-details/card-details.component';
import { CardListComponent } from './card-list/card-list.component';
import { CreateCardComponent } from './create-card/create-card.component';
import { UpdateCardComponent } from './update-card/update-card.component';
import { AppointmentAllComponent } from './appointment-all/appointment-all.component';
import { AllOrdersComponent } from './all-orders/all-orders.component';
import { AllPaymentsComponent } from './all-payments/all-payments.component';
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
    UpdateOrderComponent,
    AddressDetailsComponent,
    MycarsDetailsComponent,
    SaleDetailsComponent,
    AddAddressComponent,
    UpdateAddressComponent,
    AddSaleComponent,
    LoginComponent,
    LoginDetailsComponent,
    AdminDetailsComponent,
    CreateCardComponent,
    CardDetailsComponent,
    CardListComponent,
    UpdateCardComponent,
    AppointmentAllComponent,
    AllOrdersComponent,
    AllPaymentsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
