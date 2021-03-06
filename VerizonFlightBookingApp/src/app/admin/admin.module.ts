import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AdminLandingPageComponent } from './admin-landing-page/admin-landing-page.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { LoginComponent } from './admin-landing-page/login/login.component';
import { RegistrationComponent } from './admin-landing-page/registration/registration.component';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminLoginService } from './admin-landing-page/login/admin-login.service';
import { AdminRegistrationService } from './admin-landing-page/registration/admin-registration.service';
import { AdminViewFlightComponent } from './admin-home/admin-view-flight/admin-view-flight.component';
import { AddFlightComponent } from './admin-home/add-flight/add-flight.component';
import { AdminViewAirportComponent } from './admin-home/admin-view-airport/admin-view-airport.component';
import { AddAirportComponent } from './admin-home/add-airport/add-airport.component';

@NgModule({
  declarations: [
    AdminLandingPageComponent,
    AdminHomeComponent,
    LoginComponent,
    RegistrationComponent,
    AdminViewFlightComponent,
    AddFlightComponent,
    AdminViewAirportComponent,
    AddAirportComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AdminRoutingModule
  ],
  providers: [
    AdminLoginService,
    AdminRegistrationService
  ],
  exports: []
})
export class AdminModule { }
