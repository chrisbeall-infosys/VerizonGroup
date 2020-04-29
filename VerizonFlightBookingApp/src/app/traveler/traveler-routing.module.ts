import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TravelerHomeComponent } from './traveler-home/traveler-home.component';
import { TravelerLandingPageComponent } from './traveler-landing-page/traveler-landing-page.component';
import { LoginComponent } from './traveler-landing-page/login/login.component';
import { RegistrationComponent } from './traveler-landing-page/registration/registration.component';

const routes: Routes = [
  { path: 'applicationHome', component: TravelerLandingPageComponent, children: [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegistrationComponent}
  ] },
  { path: 'travelerHome', component: TravelerHomeComponent, children: []},
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
