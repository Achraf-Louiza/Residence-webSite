import { Injectable } from '@angular/core';
import { Residence } from './residence';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResidenceService {

  constructor(private http: HttpClient) { }

  public getResidencesWithObservable(): Observable<Residence[]> {
    return this.http.get<Residence[]>("http://localhost:8080/residences");
  }
}
