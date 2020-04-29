import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '../../../node_modules/@angular/forms';
import { BookingService } from './booking-service.service';
import { Flight } from '../shared/models/Flight';


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  flightList: Flight[] = [];
  airportList: Airport[] = [];
  airportToList: Airport[] = [];

  constructor(private fb :FormBuilder, private bookingService: BookingService) { }

  ngOnInit() {
  }

}
