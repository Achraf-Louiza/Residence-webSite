import { Injectable } from '@angular/core';
import { Residence } from './residence';
import { Studio } from './studio';
import { Client } from './client';
import { Reservation } from './reservation';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map, filter, catchError, mergeMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ResidenceService {

  constructor(private http: HttpClient) { }



  public getResidencesWithObservable(): Observable<Residence[]> {
      return this.http.get<Residence[]>("http://localhost:8080/residences");
  }

  public getStudiosWithObservable(nomResidence): Observable<Studio[]> {
    let param = new HttpParams().set('nomResidence', nomResidence);
    return this.http.get<Studio[]>("http://localhost:8080/studios", {params: param});
  }

  public getUsersWithObservable(): Observable<Client[]> {
    return this.http.get<Client[]>("http://localhost:8080/users");
  }

   public getReservationsWithObservable(nomUser): Observable<Reservation[]> {
      let param = new HttpParams().set('nomUser', nomUser);
      return this.http.get<Reservation[]>("http://localhost:8080/reservations", {params: param});
   }
  public postUser(client:Client): Observable<Client>{
    return this.http.post<Client>("http://localhost:8080/user", client);
  }

  public postStudio(studio:Studio): Observable<Studio>{
      return this.http.post<Studio>("http://localhost:8080/studio", studio);
  }

  public postRes(res: Client): Observable<Client>{
        return this.http.post<Client>("http://localhost:8080/reservation", res);
  }

  public deleteUserWithObservable(userId:string): Observable<Client>{
  return this.http.delete<Client>("http://localhost:8080/user/"+ userId);
  }

  public deleteResWithObservable(resId:string):Observable<Reservation>{
    return this.http.delete<Reservation>("http://localhost:8080/reservation/"+resId);
 }
}
