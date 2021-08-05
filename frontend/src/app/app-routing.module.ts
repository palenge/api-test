import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FirstnamesComponent } from './adapters/components/firstnames/firstnames.component';
import { HomeComponent } from './adapters/components/home/home.component';
import { LastnamesComponent } from './adapters/components/lastnames/lastnames.component';

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
