import { Component, OnInit } from '@angular/core';
import { Residence } from '../residence';
import { Client } from '../client';
import { Reservation } from '../reservation'
import { ResidenceService } from '../residence.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  users: Client[];
  selectedUser: Client;
  reservations: Reservation[];

  constructor(private residenceService: ResidenceService, private router:Router) { }

  ngOnInit(): void {
    this.getUsers();
  }

  onClick(user): void{
    this.selectedUser=user;
    this.getReservations();
  }

  getReservations(): void{
    this.residenceService.getReservationsWithObservable(this.selectedUser?.nom).subscribe(res => this.reservations = res);
  }

  getUsers(): void{
      this.residenceService.getUsersWithObservable().subscribe(users => this.users = users);
    }

  backToUsers():void{
  this.selectedUser=null;
  this.reservations=null;
  }

  goToAR():void{
   this.router.navigateByUrl("residences");
  }

  deleteUser(userId):void{
    this.residenceService.deleteUserWithObservable(userId).subscribe(vv => {console.log(vv);});
    this.getUsers();
    this.router.navigateByUrl("reservation");
  }

  deleteRes(resId):void{
      this.residenceService.deleteResWithObservable(resId).subscribe(vv => {console.log(vv);});
      this.router.navigateByUrl("reservation");
      this.getUsers();
      this.getReservations();
    }
}
