import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
   private _router: Router;

   constructor(private _router:Router) { }
   public ngOnInit(): void {
      this._router.routeReuseStrategy.shouldReuseRoute = function(){
          return false;
      };

      this._router.events.subscribe((evt) => {
          if (evt instanceof NavigationEnd) {
              this._router.navigated = false;
              window.scrollTo(0, 0);
          }
      });
   }

}
