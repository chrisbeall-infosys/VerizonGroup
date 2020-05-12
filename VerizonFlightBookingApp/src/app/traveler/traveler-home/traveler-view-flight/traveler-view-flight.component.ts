import { Component, OnInit } from '@angular/core';
import { Flight } from 'src/app/shared/models/Flight';
import { TravelerViewFlightService } from './traveler-view-flight.service';
//import { AdminViewFlightService } from 'src/app/admin/admin-home/admin-view-flight/admin-view-flight.service';

@Component({
  selector: 'app-traveler-view-flight',
  templateUrl: './traveler-view-flight.component.html',
  styleUrls: ['./traveler-view-flight.component.css']
})
export class TravelerViewFlightComponent implements OnInit {

  errorMessage: String = "";
  successMessage: String = "";

  flightList: Flight[];
  length: number;

  constructor(private travelerViewFlightService: TravelerViewFlightService) { }

  ngOnInit(): void {
    this.getFlights();
  }

  getFlights(){
    this.travelerViewFlightService.getFlights()
      .subscribe(flights => {
        this.flightList = flights;
        this.length = this.flightList.length;
      });
  }

}
