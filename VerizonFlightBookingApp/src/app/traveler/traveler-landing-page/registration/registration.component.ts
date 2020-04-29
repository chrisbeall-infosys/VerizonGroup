import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Traveler } from "../../../shared/models/traveler";
import { RegistrationService } from "./registration.service";

@Component({
  selector: 'app-traveler-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
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
      name: ['', Validators.required],
      email: ['', Validators.required],
      password:['', Validators.required],
      loginId: ['', Validators.required],

    });
  }

  registerTraveler() {
    this.errorMessage = null;
    this.successMessage = null;
    this.traveler = this.registerTravelerForm.value as Traveler;
    
    this.registerService.registerTraveler(this.traveler).subscribe(
      (response) => {console.log(response);
                      this.successMessage = response; 
                      this.registerTravelerForm.reset()}, 
       error => this.errorMessage = <any>error

    );
  }

}