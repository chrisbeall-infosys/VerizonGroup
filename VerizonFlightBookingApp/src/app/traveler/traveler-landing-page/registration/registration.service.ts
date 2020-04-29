import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import { environment } from "../../../../environments/environment";
import { Traveler } from "../../../shared/models/traveler";
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators'
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  registerTraveler(traveler: Traveler): Observable<string> {
    const url = environment.travelerAPIUrl + '/registerTraveler';
    return this.http.post<string>(url, traveler, { headers: this.headers, responseType: 'text' as 'json' })
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
