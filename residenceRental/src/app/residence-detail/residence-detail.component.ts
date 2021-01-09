import { Component, OnInit, Input } from '@angular/core';
import { Residence } from '../residence';
import { Studio } from '../studio';
import { Client } from '../client' ;
import { ResidenceService } from '../residence.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-residence-detail',
  templateUrl: './residence-detail.component.html',
  styleUrls: ['./residence-detail.component.css']
})
export class ResidenceDetailComponent implements OnInit {
  @Input() residence:Residence;
  studios: Studio[];
  toReserve = false;
  submitted = false;
  selectedStudio: Studio;

  constructor(private residenceService: ResidenceService, private router:Router) {

   }

  ngOnInit(): void {
    this.getStudios();
    this.submitted = false;
  }

  getStudios(): void{
    this.residenceService.getStudiosWithObservable(this.residence?.nom).subscribe(studios => this.studios=studios);
  }

  onClick(std): void{
  this.selectedStudio = std;
  this.residenceService.postStudio(std).subscribe(vv=> {console.log(vv);});
  this.toReserve = true;
  }

  onSubmit(value: Client): void{
   this.residenceService.postUser(value).subscribe(vv => {console.log(vv);});
   this.residenceService.postRes(value).subscribe(vv => {console.log(vv);});
   this.toReserve = false;
   this.submitted = true;
  }

  goToAR():void{
    this.router.navigateByUrl("residences");
  }

  goToR():void{
  this.router.navigateByUrl("reservation");
  }


}
