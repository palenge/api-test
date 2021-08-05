import { HttpClientModule } from '@angular/common/http';
import { forwardRef, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FullNameGateway } from './domain/gateways/fullname.gateway';
import { FirstnamesComponent } from './adapters/components/firstnames/firstnames.component';
import { FirstNameGateway } from './domain/gateways/firstname.gateway';
import { FirstNameWebGateway } from './adapters/gateways/firstname.web.gateway';
import { ReactiveFormsModule } from '@angular/forms';
import { LastNameGateway } from './domain/gateways/lastname.gateway';
import { HomeComponent } from './adapters/components/home/home.component';
import { LastnamesComponent } from './adapters/components/lastnames/lastnames.component';
import { FullNameWebGateway } from './adapters/gateways/fullname.web.gateway';
import { LastNameWebGateway } from './adapters/gateways/lastname.web.gateway';

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
