import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { AutenticacaoComponent } from './autenticacao.component';
import { RouterModule} from '@angular/router';
import { AutenticacaoRoutingModule } from './autenticacao-routing.module';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/primeng';
import { SharedModule } from '../shared/shared.module';
import { AuthService } from './service/auth.service';
import { JwtHelper } from 'angular2-jwt';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    RouterModule,
    CardModule,
    ButtonModule,
    InputTextModule,
    AutenticacaoRoutingModule
  ],
  providers: [AuthService, JwtHelper],
  declarations: [AutenticacaoComponent, LoginComponent]
})
export class AutenticacaoModule { }
