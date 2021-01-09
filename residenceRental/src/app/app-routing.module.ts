import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResidencesComponent } from './residences/residences.component';
import { ReservationComponent } from './reservation/reservation.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
const routes: Routes = [
  { path: 'residences', component: ResidencesComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'reservation', component: ReservationComponent},
  { path: 'home', component: HomeComponent},
   { path: '',   redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
