import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Traveler } from "../../../shared/models/traveler";
import { RegistrationService } from "./registration.service";
import { LoginValidators } from "../../../shared/validators/login.validator";

@Component({
  selector: 'app-traveler-registration',
  templateUrl: './registration.component.html'
  //styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
    traveler: Traveler;
    registerTravelerForm: FormGroup;
    errorMessage: string;
    successMessage: string;
  constructor(private fb: FormBuilder, private registerService: RegistrationService) {
  }

  ngOnInit(): void {
    this.traveler = new Traveler();
    this.createForm();

  }
createForm() {
      this.registerTravelerForm = this.fb.group({
      name: [this.traveler.name, [Validators.required,LoginValidators.validateName], null],
      email: [this.traveler.email, [Validators.required,LoginValidators.validateEmail], null],
      password:[this.traveler.password, [Validators.required, LoginValidators.validatePassword], null],
      loginId: [this.traveler.loginId, [Validators.required,LoginValidators.validateLoginId], null],

    });
  }

  registerTraveler() {
    this.errorMessage = null;
    this.successMessage = null;
    this.traveler = this.registerTravelerForm.value as Traveler;
    
    this.registerService.registerTraveler(this.traveler).subscribe(
      message => {
        this.successMessage = message;
        this.registerTravelerForm.reset();
      }, 
      error => this.errorMessage = <any>error );
  }

}