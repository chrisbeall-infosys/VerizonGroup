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
  addBookingForm: FormGroup;
  flightList: Flight[] = [];
  airportList: Airport[] = [];

  airportMap: object = {};
  selectedFlight: Flight;
  successMessage: string;
  errorMessage: string;

  fromSelected(value: any) {
    this.flightList = this.airportMap[value];
  }

  selectFlight() {
    console.log(this.addBookingForm.get('toAirport').value);
  }

  bookingSubmit() {
    let booking: Booking = new Booking();
    booking.dateOfTravel = this.addBookingForm.get('dateOfTravel').value;
    booking.flight = this.addBookingForm.get('toAirport').value;
    booking.numberOfTravelers = this.addBookingForm.get('numberOfTravelers').value;
    booking.traveler = JSON.parse(sessionStorage.getItem("traveler"));
    console.log(booking);
    this.bookingService.addNewBooking(booking).subscribe(
      success => {
        this.successMessage = "Your flight has been booked!";
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      },
    )
  };


  constructor(private fb: FormBuilder, private bookingService: BookingService, private flightService: BookingGetFlightsService) { }

  ngOnInit() {
    this.addBookingForm = this.fb.group({
      flight: ['', [Validators.required]],
      traveler: ['', [Validators.required]],
      fromAirport: ['', [Validators.required]],
      toAirport: ['', [Validators.required]],
      numberOfTravelers: ['', Validators.required],
      dateOfTravel: ['', [Validators.required]]
    });

    this.flightService.getFlights()
      .subscribe((flightList) => {
        this.flightList = flightList;
      }, (err) => {
        console.error(err);
        this.errorMessage = err.error.message;
      },
        () => {
          for (let flight of this.flightList) {
            if (this.airportMap.hasOwnProperty(flight.fromAirport.airportId)) {
              this.airportMap[flight.fromAirport.airportId].push(flight)
              
            }
            else {
              this.airportList.push(flight.fromAirport);
              this.airportMap[flight.fromAirport.airportId] = [flight]
            }
            
          }

        });
  }

}
