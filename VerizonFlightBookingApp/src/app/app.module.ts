import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { AdminLandingPageComponent } from './admin/admin-landing-page/admin-landing-page.component';
import { LoginComponent } from './admin/admin-landing-page/login/login.component';
import { RegistrationComponent } from './admin/admin-landing-page/registration/registration.component';
import { TravelerHomeComponent } from './traveler/traveler-home/traveler-home.component';
import { TravelerLandingPageComponent } from './traveler/traveler-landing-page/traveler-landing-page.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    AdminLandingPageComponent,
    LoginComponent,
    RegistrationComponent,
    TravelerHomeComponent,
    TravelerLandingPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
