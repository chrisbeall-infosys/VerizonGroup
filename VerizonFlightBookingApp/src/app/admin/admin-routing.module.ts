import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AdminHomeComponent } from './admin-home/admin-home.component';

import { AdminLandingPageComponent } from './admin-landing-page/admin-landing-page.component';
import { RegistrationComponent } from './admin-landing-page/registration/registration.component';
import { LoginComponent } from './admin-landing-page/login/login.component';

const routes: Routes = [

  { path: 'admin', component: AdminLandingPageComponent, children: [
    {path: 'login', component: LoginComponent},
    {path: 'register', component:RegistrationComponent},
    {path: '', redirectTo: 'login', pathMatch: 'full'}
  ]},
  {
    path: 'adminHome', component: AdminHomeComponent, children: [
      
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
