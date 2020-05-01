import { Injectable } from '@angular/core';
import { HttpErrorResponse, HttpClient } from '../../../node_modules/@angular/common/http';
import { Flight } from '../shared/models/Flight';
import { Observable, throwError } from '../../../node_modules/rxjs';
import { catchError } from '../../../node_modules/rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class BookingGetFlightsService {
  getFlights(): Observable<Flight[]>{
    const url = "http://localhost:3333/verizon_group_project/flightAPI/getFlights";
    return this.http.get<Flight[]>(url)
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
  constructor(private http: HttpClient) { }
}
