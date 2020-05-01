import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '../../../../node_modules/@angular/forms';
import { BookingService } from './booking-service.service';

import { BookingGetFlightsService } from './booking-get-flights.service';
import { Flight } from '../../shared/models/Flight';
import { Airport } from '../../shared/models/airport';
import { Booking } from '../../shared/models/booking';


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  newBookingForm: FormGroup;
  flightList: Flight[];
  airportList: Airport[];
  
  airportMap: object;
  airportToList: Airport[];
  selectedFlight: Flight;
  successMessage:string;
  errorMessage:string;

  fromSelected(value: any) {
    this.airportToList = this.airportMap[value];
  }

  bookingSubmit(){
    let booking:Booking = new Booking();
    booking.dateOfTravel = this.newBookingForm.get('dateOfTravel').value;
    booking.flight = this.selectedFlight;
    booking.numberOfTravelers = this.newBookingForm.get('numberOfTravelers').value;
    booking.traveler = JSON.parse(sessionStorage.getItem("traveler"));
    this.bookingService.addNewBooking(booking).subscribe(
      (success) => {
        this.successMessage = "Deal Added!";
      },
      (error) => {
        this.errorMessage = error.error.message;
      }
    )};


  constructor(private fb: FormBuilder, private bookingService: BookingService, private flightService: BookingGetFlightsService) { }

  ngOnInit() {
    this.newBookingForm = this.fb.group({
      flight: ['', [Validators.required]],
      traveler: ['', [Validators.required]],
      fromAirport: ['', [Validators.required]],
      toAirport :['', [Validators.required]],
      numberOfTravelers: ['', Validators.required],
      dateOfTravel: ['', [Validators.required]]      
    });

    let flightList = this.flightService.getFlights();
    for (let flight of this.flightList) {
      if (this.airportMap.hasOwnProperty(flight.fromAirport.airportId)) {
        this.airportMap[flight.fromAirport.airportId].push(flight.toAirport.airportId)
      }
      else {
        this.airportList.push(flight.fromAirport);
        this.airportMap[flight.fromAirport.airportId] = [flight.toAirport.airportId]
      }

    }
  }

}
