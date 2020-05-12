import { Component, OnInit } from '@angular/core';
import { Airport } from 'src/app/shared/models/Airport';
import { AdminViewAirportService } from './admin-view-airport.service';

@Component({
  selector: 'app-admin-view-airport',
  templateUrl: './admin-view-airport.component.html',
  styleUrls: ['./admin-view-airport.component.css']
})
export class AdminViewAirportComponent implements OnInit {

  errorMessage: String = "";
  successMessage: String = "";

  airportList: Airport[];

  length: number = 0;

  constructor(private adminViewAirportService: AdminViewAirportService) { }

  ngOnInit(): void {
    this.getAirports();
  }

  getAirports(){
    this.adminViewAirportService.getAirports()
      .subscribe(airports => {
        this.airportList = airports;
        this.length = this.airportList.length;
      });
  }

  removeAirport(airport: Airport){
    this.adminViewAirportService.removeAirport(airport)
      .subscribe(
        success => {
          console.log(success);
          this.successMessage = success;
          let newAirportList: Airport[] = [];
          for(let tempAirport of this.airportList){
            if(tempAirport.airportId != airport.airportId){
              newAirportList.push(tempAirport);
            }
          }
          this.airportList = newAirportList;
        },
        error => {
          console.log(error);
          this.errorMessage = error.error.message;
        }
      );
    
  }

}
