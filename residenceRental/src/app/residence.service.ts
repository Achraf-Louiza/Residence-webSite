import { Injectable } from '@angular/core';
import { Residence } from './residence';
import { Studio } from './studio';
import { Client } from './client';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';

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

  public postUser(client:Client): Observable<Client>{
    return this.http.post<Client>("http://localhost:8080/user", client);
  }

  public postStudio(studio:Studio): Observable<Studio>{
      return this.http.post<Studio>("http://localhost:8080/studio", studio);
  }

  public postRes(res: Client): Observable<Client>{
        return this.http.post<Client>("http://localhost:8080/reservation", res);
  }
}
