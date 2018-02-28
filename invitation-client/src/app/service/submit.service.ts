import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs/Observable";

@Injectable()
export class SubmitService {

  constructor(private httpClient: HttpClient) {
  }

  submit(date: Date, email:string): Observable<any> {
    return this.httpClient.post(`${environment.apiUrl}/invitation/`, {
      'date': date,
      'email':email
    });
  }

}
