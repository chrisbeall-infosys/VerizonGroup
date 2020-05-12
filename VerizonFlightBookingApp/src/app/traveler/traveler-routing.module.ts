import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VerizonRoutingGuard } from '../app.routing-guard';

import { RouterModule, Routes } from '@angular/router';
import { TravelerHomeComponent } from './traveler-home/traveler-home.component';
import { TravelerLandingPageComponent } from './traveler-landing-page/traveler-landing-page.component';
import { LoginComponent } from './traveler-landing-page/login/login.component';
import { RegistrationComponent } from './traveler-landing-page/registration/registration.component';
import { BookingComponent } from './booking/booking.component';
import { TravelerViewFlightComponent } from './traveler-home/traveler-view-flight/traveler-view-flight.component';
import { TravelerViewAirportComponent } from './traveler-home/traveler-view-airport/traveler-view-airport.component';

const routes: Routes = [
  { path: 'applicationHome', component: TravelerLandingPageComponent, children: [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegistrationComponent}
  ] },
  { path: 'travelerHome', component: TravelerHomeComponent,canActivate: [VerizonRoutingGuard], children: [
    {path: '', redirectTo: 'travelerHome', pathMatch: 'full'},
    {path:'booking', component:BookingComponent},
    { path: 'viewFlights', component: TravelerViewFlightComponent},
    { path: 'viewAirports', component: TravelerViewAirportComponent}
  ]},
  { path: '', redirectTo: '/applicationHome', pathMatch: 'full' }

];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class TravelerRoutingModule { }
