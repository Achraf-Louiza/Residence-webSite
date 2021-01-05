import { Component, OnInit, Input } from '@angular/core';
import { Residence } from '../residence';
import { Studio } from '../studio';
import { ResidenceService } from '../residence.service';

@Component({
  selector: 'app-residence-detail',
  templateUrl: './residence-detail.component.html',
  styleUrls: ['./residence-detail.component.css']
})
export class ResidenceDetailComponent implements OnInit {
  @Input() residence:Residence;
  studios: Studio[];


  constructor(private residenceService: ResidenceService) {

   }

  ngOnInit(): void {
    this.getStudios();
  }

  getStudios(): void{
    this.residenceService.getStudiosWithObservable(this.residence?.nom).subscribe(studios => this.studios=studios);
  }



}
