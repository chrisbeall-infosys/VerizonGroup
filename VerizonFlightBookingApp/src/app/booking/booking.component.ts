import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '../../../node_modules/@angular/forms';
import { BookingService } from './booking-service.service';
import { Flight } from '../shared/models/Flight';
import { Airport } from '../shared/models/airport';


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  flightList: Flight;
  airportList: Airport[];
  airportMap: object;
  airportToList: Airport[]; 

  fromSelected(value: any){
    
  }

  constructor(private fb :FormBuilder, private bookingService: BookingService) { }

  ngOnInit() {
    this.airportList = getAirportList();
    for (let airport in this.airportList){
      this.airportMap[airport] = getAirportToList();
    }
  }

}
