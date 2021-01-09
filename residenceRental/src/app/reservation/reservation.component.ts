import { Component, OnInit } from '@angular/core';
import { Residence } from '../residence';
import { Client } from '../client';
import { Reservation } from '../reservation'
import { ResidenceService } from '../residence.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  users: Client[];
  selectedUser: Client;
  reservations: Reservation[];

  constructor(private residenceService: ResidenceService) { }

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
}
