import { Component, OnInit } from '@angular/core';
import { Flight } from 'src/app/shared/models/Flight';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { AddFlightService } from './add-flight.service';
import { Airport } from 'src/app/shared/models/airport';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {

  flightToAdd: any;
  errorMessage: string = "";
  successMessage: string = "";

  addFlightForm: FormGroup;

  constructor(private fb: FormBuilder, private addFlightService: AddFlightService) { }

  ngOnInit(): void {
    
    this.createForm();
    
  }

  createForm(){
    this.addFlightForm = this.fb.group({
      //description: new FormControl("", [Validators.required, Validators.minLength(10)]),
      flightId: ["", [Validators.required, Validators.min(0)]],
      fare: ["", [Validators.required, Validators.min(1)]],
      taxes: ["", [Validators.required, Validators.min(1)]],
      toAir: ["", Validators.required],
      fromAir: ["", Validators.required]
    })
  }

  addFlight(){

    let flight: Flight = new Flight();
    flight.flightId = this.addFlightForm.get('flightId').value;
    flight.fare = this.addFlightForm.get('fare').value;
    flight.taxes = this.addFlightForm.get('taxes').value;
    let toAirport: Airport = new Airport();
    toAirport.airportId = this.addFlightForm.get('toAir').value;
    flight.toAirport = toAirport;
    let fromAirport: Airport = new Airport();
    fromAirport.airportId = this.addFlightForm.get('fromAir').value;
    flight.fromAirport = fromAirport;
    
    console.log(flight);
    this.addFlightService.addFlight(flight).subscribe(
      success => {
        console.log(success);
        this.successMessage = success;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    )

  }

}
