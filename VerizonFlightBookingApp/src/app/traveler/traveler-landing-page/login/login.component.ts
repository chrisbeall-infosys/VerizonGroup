import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { RouterModule, Router } from '@angular/router';
import { LoginValidators } from '../../../shared/validators/login.validator';
import { Traveler } from '../../../shared/models/traveler';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
  //styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  traveler: Traveler;
  loginForm: FormGroup;
  errorMessage: string;
  successMessage: string;
  tryToLogin: boolean = false;
  constructor(private fb: FormBuilder, private loginService: LoginService,
    private router: Router) { }

  ngOnInit(): void {
    this.traveler = new Traveler();
    this.createForm();
  }
  createForm() {

    this.loginForm = this.fb.group({
        loginId: [this.traveler.loginId, [Validators.required, LoginValidators.validateLoginId], null],
        password: [this.traveler.password, [Validators.required, LoginValidators.validatePassword], null]
    });
}

login() {
  this.tryToLogin = true;
  this.errorMessage = null;
  this.successMessage = null;
  this.traveler = this.loginForm.value as Traveler;
  this.loginService.login(this.traveler).subscribe(
      (response) => {
          this.traveler = response
          sessionStorage.setItem("traveler", JSON.stringify(this.traveler));
          sessionStorage.setItem("userType", JSON.stringify("Traveler"));
          this.tryToLogin = false;
          this.router.navigate(['/travelerHome']);
      },
      (error) => {
          this.tryToLogin = false;
          this.errorMessage = <any>error;
      }
  )
}
}