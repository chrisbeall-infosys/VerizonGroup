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
  successMessage: String = "";

  flightList: Flight[];
  length: number;

  constructor(private adminViewFlightService: AdminViewFlightService) { }

  ngOnInit(): void {
    this.getFlights();
  }

  getFlights(){
    this.adminViewFlightService.getFlights()
      .subscribe(flights => {
        this.flightList = flights;
        this.length = this.flightList.length;
      });
  }

  removeFlight(flight: Flight){
    this.adminViewFlightService.removeFlight(flight)
      .subscribe(
        success => {
          console.log(success);
          this.successMessage = success;
          let newFlightList: Flight[] = [];
          for(let tempFlight of this.flightList){
            if(tempFlight.flightId != flight.flightId){
              newFlightList.push(tempFlight);
            }
          }
          this.flightList = newFlightList;
        },
        error => {
          console.log(error);
          this.errorMessage = error.error.message;
        }
      );
      setTimeout(() => {console.log("Delay");}, 5000);
      window.location.reload();   // this sometimes caueses erors, when it reloads too soon, hence delay.
  }

}
