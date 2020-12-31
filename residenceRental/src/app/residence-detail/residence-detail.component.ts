import { Component, OnInit, Input } from '@angular/core';
import { Residence } from '../residence';

@Component({
  selector: 'app-residence-detail',
  templateUrl: './residence-detail.component.html',
  styleUrls: ['./residence-detail.component.css']
})
export class ResidenceDetailComponent implements OnInit {
  @Input() residence:Residence;
  constructor() { }

  ngOnInit(): void {
  }

}
