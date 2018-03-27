import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { PrincipalComponent } from './principal/principal.component';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { AuthService } from './autenticacao/service/auth.service';
import { HttpClient, HttpClientModule, HttpHandler } from '@angular/common/http';
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';
import { SharedModule } from './shared/shared.module';
import {AuthGuard} from './autenticacao/service/auth.guard';
import {RoleGuard} from './autenticacao/service/role-guard.service';


@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    SharedModule,
    AppRoutingModule,
  ],
  exports: [
    SharedModule
  ],
  declarations: [
    AppComponent,
    PrincipalComponent
  ],
  providers: [AuthService, AuthGuard, RoleGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
