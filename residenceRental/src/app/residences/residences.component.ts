import { Component, OnInit } from '@angular/core';
import { Residence } from '../residence';
import { ResidenceService } from '../residence.service';


@Component({
  selector: 'app-residences',
  templateUrl: './residences.component.html',
  styleUrls: ['./residences.component.css']
})
export class ResidencesComponent implements OnInit {
    residences: Residence[];
    selectedResidence: Residence;


    constructor(private residenceService: ResidenceService) { }

    ngOnInit(): void {
      this.getResidences();
      this.selectedResidence=null;
    }
    getResidences(): void {
        this.residenceService.getResidencesWithObservable().subscribe(residences => this.residences = residences);
    }
    onSelect(residence: Residence){
      this.selectedResidence = residence;
    }

}
