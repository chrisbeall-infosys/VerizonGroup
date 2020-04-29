import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuthorizationErrorComponent} from './shared/authorization-error/authorization-error.component'

const routes: Routes = [ {path:'error',component:AuthorizationErrorComponent},
{path:'',redirectTo:'/applicationHome/login',pathMatch:'full'}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
