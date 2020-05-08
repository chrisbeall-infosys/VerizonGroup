import { Component, OnInit, Input } from '@angular/core';

import { Flight } from 'src/app/shared/models/Flight';
import { AdminViewFlightService } from './admin-view-flight.service';

@Component({
  selector: 'app-admin-view-flight',
  templateUrl: './admin-view-flight.component.html',
  styleUrls: ['./admin-view-flight.component.css']
})
export class AdminViewFlightComponent implements OnInit {

  errorMessage: String = "";
  successMessage: number = 0;

  flightList: Flight[];
  flightListToDisplay: Flight[] = []; // used for searching

  constructor(private adminViewFlightService: AdminViewFlightService) { }

  ngOnInit(): void {
    this.getFlights();
  }

  getFlights(){
    this.adminViewFlightService.getFlights()
      .subscribe(flights => {
        this.flightList = flights;
        this.flightListToDisplay = this.flightList;
      });
  }

  removeFlight(flight: Flight){
    this.adminViewFlightService.removeFlight(flight)
      .subscribe(
        success => {
          console.log(success);
          this.successMessage = success;
        },
        error => {
          console.log(error);
          this.errorMessage = error.error.message;
        }
      );
    this.getFlights();
  }

}
