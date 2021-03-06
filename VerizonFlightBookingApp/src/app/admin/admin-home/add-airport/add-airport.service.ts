import { Injectable } from '@angular/core';

import { Observable, throwError } from '../../../../../node_modules/rxjs';
import { HttpClient, HttpErrorResponse } from '../../../../../node_modules/@angular/common/http';
import { catchError } from '../../../../../node_modules/rxjs/operators';
import { Airport } from 'src/app/shared/models/airport';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AddAirportService {

  constructor(private http: HttpClient) { }

  addAirport(airport: Airport): Observable<string> {
    const url = environment.airportAPIUrl + "/airport";
    return this.http.post<string>(url, airport, {responseType: 'text' as 'json'})
      .pipe(catchError(this.handleError));
  }

  handleError(error : HttpErrorResponse){
    console.log(error)
    let errMsg:string='';
    if (error.error instanceof Error) {   
        errMsg=error.error.message;
        console.log(errMsg)
    }
     else if(typeof error.error === 'string'){
        errMsg=JSON.parse(error.error).message
    }
    else {
       if(error.status==0){ 
           errMsg="A connection to back end can not be established.";
       }else{
           errMsg=error.error.message;
       }
     }
        return throwError(errMsg);
  }

}
