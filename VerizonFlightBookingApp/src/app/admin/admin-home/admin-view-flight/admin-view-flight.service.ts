import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse } from '../../../../../node_modules/@angular/common/http';
import { catchError } from '../../../../../node_modules/rxjs/operators';
import { Flight } from 'src/app/shared/models/flight';

@Injectable({
  providedIn: 'root'
})
export class AdminViewFlightService {

  constructor(private http: HttpClient) { }

  getFlights(): Observable<Flight[]> {
    let url = environment.flightAPIUrl + "/getFlights";
    return this.http.get<Flight[]>(url)
      .pipe(catchError(this.handleError))
  }

  removeFlight(flight: Flight){
    const url = environment.flightAPIUrl + "/removeFlight";
    return this.http.post<String>(url, flight.flightId, {responseType: 'text' as 'json'})
      .pipe(catchError(this.handleError));
  }

  private handleError(err: HttpErrorResponse) {
    console.log(err)
    let errMsg:string='';
    if (err.error instanceof Error) {   
        errMsg=err.error.message;
        console.log(errMsg)
    }
     else if(typeof err.error === 'string'){
        errMsg=JSON.parse(err.error).message
    }
    else {
       if(err.status==0){ 
           errMsg="A connection to back end can not be established.";
       }else{
           errMsg=err.error.message;
       }
     }
        return throwError(errMsg);
  }

}
