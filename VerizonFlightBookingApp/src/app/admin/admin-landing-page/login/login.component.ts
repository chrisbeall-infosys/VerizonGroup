import { Component, OnInit } from '@angular/core';
import { AdminLoginService } from './admin-login.service';
import { RouterModule, Router } from '@angular/router';

import { Admin } from '../../../shared/models/admin';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    admin: Admin;
    loginForm: FormGroup;
    errorMessage: string;
    successMessage: string;
    tryToLogin: boolean = false;
  constructor(private fb: FormBuilder, 
              private loginService: AdminLoginService,
              private router: Router) { }

  ngOnInit(): void {
    this.admin = new Admin();
    
  }

  createForm() {

    this.loginForm = this.fb.group({
        loginId: [this.admin.loginId, [Validators.required], null],
        password: [this.admin.password, [Validators.required], null]
    });
  
}
login() {
  this.errorMessage = null;
  this.successMessage = null;
  this.admin = this.loginForm.value as Admin;

  this.loginService.login(this.admin).subscribe(
      (response) => {
          this.admin = response;
          sessionStorage.setItem("admin", JSON.stringify(this.admin));
          sessionStorage.setItem("userType", JSON.stringify("Admin"));

          this.router.navigate(['/adminHome']);
      }, error => this.errorMessage = <any>error
  )
}


}
