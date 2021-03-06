import { Component, OnInit } from '@angular/core';
import { Admin } from '../../../shared/models/admin';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { LoginValidators } from "../../../shared/validators/login.validator";
import { AdminRegistrationService } from './admin-registration.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html'
  //styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  admin: Admin;
  registerAdminForm: FormGroup;
  errorMessage: string;
  successMessage: string;

  constructor(private fb: FormBuilder,
              private registerService: AdminRegistrationService) { }

  ngOnInit(): void {
    this.admin = new Admin();
    this.createForm();
  }
  createForm() {
    this.registerAdminForm = this.fb.group({
      name: ['', [Validators.required, LoginValidators.validateName], null],
      email: ['', [Validators.required, LoginValidators.validateEmail], null],
      password:['', [Validators.required, LoginValidators.validatePassword], null],
      loginId: ['', [Validators.required, LoginValidators.validateLoginId], null],

    });
  }

  registerAdmin() {
    this.errorMessage = null;
    this.successMessage = null;
    this.admin = this.registerAdminForm.value as Admin;
    
    this.registerService.registerAdmin(this.admin).subscribe(
      (response) => {console.log(response);
                      this.successMessage = response; 
                      this.registerAdminForm.reset()}, 
       error => this.errorMessage = <any>error

    );
  }

}
