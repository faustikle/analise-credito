import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import { PrincipalComponent } from './principal/principal.component';
import {CardModule} from 'primeng/card';
import {ButtonModule} from 'primeng/button';


@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    CardModule,
    ButtonModule
  ],
  declarations: [
    AppComponent,
    PrincipalComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
