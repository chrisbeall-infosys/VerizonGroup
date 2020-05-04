import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthorizationErrorComponent } from './shared/authorization-error/authorization-error.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminModule } from './admin/admin.module';
import { TravelerModule } from './traveler/traveler.module';

import { BookingService } from './booking/booking-service.service';
import { VerizonRoutingGuard } from './app.routing-guard';
import { FlightComponent } from './flight/flight.component';
import { AirportComponent } from './airport/airport.component';


@NgModule({
  declarations: [
    AppComponent,
    AuthorizationErrorComponent,
    FlightComponent,
    AirportComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    AdminModule,
    TravelerModule
  ],

  providers: [VerizonRoutingGuard, BookingService],

  bootstrap: [AppComponent]
})
export class AppModule { }
