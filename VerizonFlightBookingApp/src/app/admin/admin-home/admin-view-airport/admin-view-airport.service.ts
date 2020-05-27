import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse } from '../../../../../node_modules/@angular/common/http';
import { catchError } from '../../../../../node_modules/rxjs/operators';
import { Airport } from 'src/app/shared/models/airport';
import { error } from '@angular/compiler/src/util';

@Injectable({
  providedIn: 'root'
})
export class AdminViewAirportService {

  constructor(private http: HttpClient) { }

  getAirports(): Observable<Airport[]> {
    let url = environment.airportAPIUrl + "/airport";
    return this.http.get<Airport[]>(url)
      .pipe(catchError(this.handleError))
  }

  removeAirport(airport: Airport){
    const url = environment.airportAPIUrl + "/airport/" + airport.airportId;
    return this.http.delete<String>(url, {responseType: 'text' as 'json'})
      .pipe(catchError(this.handleError));
  }

  private handleError(err: HttpErrorResponse) {

    console.log(err);
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
