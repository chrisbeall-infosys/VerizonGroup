import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '../../../../node_modules/@angular/forms';
import { BookingService } from './booking-service.service';

import { BookingGetFlightsService } from './booking-get-flights.service';
import { Flight } from '../../shared/models/Flight';
import { Airport } from '../../shared/models/airport';
import { Booking } from '../../shared/models/booking';
import { DateValidator } from './booking.validator';


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  addBookingForm: FormGroup;
  flightList: Flight[] = [];
  airportList: Airport[] = [];
  isNumberEntered: boolean =false;
  airportMap: object = {};
  
  
  successMessage: string;
  errorMessage: string;
  total: number = 0; 
  fare: number;
  taxes: number;

  fromSelected(value: any) {
    this.flightList = this.airportMap[value];
    this.addBookingForm.get('toAirport').enable();
  }


  changeNumberOfTravelers(){
   
    if (this.addBookingForm.get('numberOfTravelers').value > 0){
      this.calculateTotal();
      this.isNumberEntered = true;
    }
    else{
      this.isNumberEntered = false;
    }
  }
  calculateTotal(){
    let selectedFlight: Flight = this.addBookingForm.get('toAirport').value;
    this.total =  (selectedFlight.fare + selectedFlight.taxes) * this.addBookingForm.get('numberOfTravelers').value;
    this.fare = selectedFlight.fare;
    this.taxes = selectedFlight.taxes;
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
        console.log(success);
        this.successMessage = success;
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
      traveler: ['', [Validators.required]],
      fromAirport: ['', [Validators.required]],
      toAirport: [ {value: '', disabled: true}, [Validators.required]],
      numberOfTravelers: ['', [Validators.required, Validators.min(1)]],
      dateOfTravel: ['', [Validators.required, DateValidator.today, DateValidator.year]]
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
