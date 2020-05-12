import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { AddAirportService } from './add-airport.service';
import { Airport } from 'src/app/shared/models/airport';

@Component({
  selector: 'app-add-airport',
  templateUrl: './add-airport.component.html',
  styleUrls: ['./add-airport.component.css']
})
export class AddAirportComponent implements OnInit {

  errorMessage: string = "";
  successMessage: string = "";

  addAirportForm: FormGroup;

  constructor(private fb: FormBuilder, private addAirportService: AddAirportService) { }

  ngOnInit(): void {
    
    this.createForm();
    
  }

  createForm(){
    this.addAirportForm = this.fb.group({
      airportId: ["", [Validators.required, Validators.minLength(1), Validators.maxLength(4)]]
    })
  }

  addAirport(){

    let airport: Airport = new Airport();
    airport.airportId = this.addAirportForm.get('airportId').value;
    
    console.log(airport);
    this.addAirportService.addAirport(airport).subscribe(
      success => {
        console.log(success);
        this.successMessage = success;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    )
    this.addAirportForm.reset();
  }

}
