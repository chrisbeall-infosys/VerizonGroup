import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TravelerRoutingModule } from './traveler-routing.module';
import { LoginComponent } from './traveler-landing-page/login/login.component';
import { RegistrationComponent } from './traveler-landing-page/registration/registration.component';
import { LoginService } from './traveler-landing-page/login/login.service';
import { RegistrationService } from './traveler-landing-page/registration/registration.service';
import { TravelerHomeComponent } from './traveler-home/traveler-home.component';
import { TravelerLandingPageComponent } from './traveler-landing-page/traveler-landing-page.component';
import { BookingGetFlightsService } from './booking/booking-get-flights.service';
import { BookingService } from './booking/booking-service.service';
import { BookingComponent } from './booking/booking.component';
import { TravelerViewFlightComponent } from './traveler-home/traveler-view-flight/traveler-view-flight.component';
import { TravelerViewAirportComponent } from './traveler-home/traveler-view-airport/traveler-view-airport.component';


@NgModule({
  declarations: [
    TravelerHomeComponent,
    TravelerLandingPageComponent,
    LoginComponent,
    RegistrationComponent,
    BookingComponent,
    TravelerViewFlightComponent,
    TravelerViewAirportComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    TravelerRoutingModule
    
  ],
  providers: [
    LoginService,
    RegistrationService,
    BookingService,
    BookingGetFlightsService
  ],
  exports: []
})
export class TravelerModule { }
