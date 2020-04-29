import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/shared/models/admin';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { AdminLandingPageComponent } from '../admin-landing-page.component';
import { AdminRegistrationService } from './admin-registration.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
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
      name: ['', Validators.required],
      email: ['', Validators.required],
      password:['', Validators.required],
      loginId: ['', Validators.required],

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
