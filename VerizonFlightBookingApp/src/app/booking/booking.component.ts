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

  flightList: Flight[];
  airportList: Airport[];
  airportMap: object;
  airportToList: Airport[];

  fromSelected(value: any) {
    this.airportToList = this.airportMap[value];
  }


  constructor(private fb: FormBuilder, private bookingService: BookingService, private flightService: FlightService) { }

  ngOnInit() {
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
