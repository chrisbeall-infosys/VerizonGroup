import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VerizonRoutingGuard } from '../app.routing-guard';

import { CommonModule } from '@angular/common';
import { AdminHomeComponent } from './admin-home/admin-home.component';

import { AdminLandingPageComponent } from './admin-landing-page/admin-landing-page.component';
import { RegistrationComponent } from './admin-landing-page/registration/registration.component';
import { LoginComponent } from './admin-landing-page/login/login.component';
import { AdminViewFlightComponent } from './admin-home/admin-view-flight/admin-view-flight.component';
import { AddFlightComponent } from './admin-home/add-flight/add-flight.component';

const routes: Routes = [

  { path: 'admin', component: AdminLandingPageComponent, children: [
    {path: 'login', component: LoginComponent},
    {path: 'register', component:RegistrationComponent},
    {path: '', redirectTo: 'login', pathMatch: 'full'}
  ]},
  {
    path: 'adminHome', component: AdminHomeComponent,canActivate:[VerizonRoutingGuard], children: [
      { path: 'viewFlights', component: AdminViewFlightComponent},
      { path: 'addFlight', component: AddFlightComponent}
    ]
  },
  {path:'adminRegistration',component:RegistrationComponent},
  { path: '', redirectTo: '/applicationHome', pathMatch: 'full' }


  ]
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports:[RouterModule]
})
export class AdminRoutingModule { }
