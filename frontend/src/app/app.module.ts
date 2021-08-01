import { HttpClientModule } from '@angular/common/http';
import { forwardRef, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FullNameWebGateway } from './adapters/fullname.web.gateway';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FullNameGateway } from './domain/gateways/fullname.gateway';
import { HomeComponent } from './home/home.component';
import { FirstnamesComponent } from './firstnames/firstnames.component';
import { FirstNameGateway } from './domain/gateways/firstname.gateway';
import { FirstNameWebGateway } from './adapters/firstname.web.gateway';
import { ReactiveFormsModule } from '@angular/forms';
import { LastNameGateway } from './domain/gateways/lastname.gateway';
import { LastNameWebGateway } from './adapters/lastname.web.gateway';
import { LastnamesComponent } from './lastnames/lastnames.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, FirstnamesComponent, LastnamesComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [
    {
      provide: FullNameGateway,
      useClass: forwardRef(() => FullNameWebGateway),
    },
    {
      provide: FirstNameGateway,
      useClass: forwardRef(() => FirstNameWebGateway),
    },
    {
      provide: LastNameGateway,
      useClass: forwardRef(() => LastNameWebGateway),
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
