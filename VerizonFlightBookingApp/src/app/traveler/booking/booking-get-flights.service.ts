import { Injectable } from '@angular/core';
import { Observable, throwError } from '../../../../node_modules/rxjs';
import { Flight } from '../../shared/models/Flight';
import { HttpErrorResponse, HttpClient, HttpHeaders} from '../../../../node_modules/@angular/common/http';
import { catchError } from '../../../../node_modules/rxjs/operators';
import { environment } from '../../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class BookingGetFlightsService {

  private headers = new HttpHeaders({ 'Content-Type': 'text/plain' });

  getFlights(): Observable<Flight[]>{
    const url = environment.flightAPIUrl +'/getFlights';
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
