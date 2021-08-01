import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstnamesComponent } from './firstnames/firstnames.component';
import { HomeComponent } from './home/home.component';
import { LastnamesComponent } from './lastnames/lastnames.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: '',
        component: HomeComponent,
      },
      {
        path: 'firstnames',
        component: FirstnamesComponent,
      },
      {
        path: 'lastnames',
        component: LastnamesComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
