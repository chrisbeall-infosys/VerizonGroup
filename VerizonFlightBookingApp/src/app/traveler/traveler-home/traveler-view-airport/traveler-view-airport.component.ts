import { Component, OnInit } from '@angular/core';
import { Airport } from 'src/app/shared/models/Airport';
import { TravelerViewAirportService } from './traveler-view-airport.service';

@Component({
  selector: 'app-traveler-view-airport',
  templateUrl: './traveler-view-airport.component.html',
  styleUrls: ['./traveler-view-airport.component.css']
})
export class TravelerViewAirportComponent implements OnInit {

  errorMessage: String = "";
  successMessage: String = "";

  airportList: Airport[];

  length: number = 0;

  constructor(private travelerViewAirportService: TravelerViewAirportService) { }

  ngOnInit(): void {
    this.getAirports();
  }

  getAirports(){
    this.travelerViewAirportService.getAirports()
      .subscribe(airports => {
        this.airportList = airports;
        this.length = this.airportList.length;
      });
  }

}
