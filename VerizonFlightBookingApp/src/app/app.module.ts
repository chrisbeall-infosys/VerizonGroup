import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthorizationErrorComponent } from './shared/authorization-error/authorization-error.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminModule } from './admin/admin.module';
import { TravelerModule } from './traveler/traveler.module';

@NgModule({
  declarations: [
    AppComponent,
    AuthorizationErrorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    AdminModule,
    TravelerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
