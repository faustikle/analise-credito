import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { CadastroComponent } from './cadastro/cadastro.component';
import { ResultadoComponent } from './resultado/resultado.component';
import { PropostaRoutingModule } from './proposta-routing.module';
import {PropostaComponent} from './proposta.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    PropostaRoutingModule
  ],
  declarations: [PropostaComponent, CadastroComponent, ResultadoComponent]
})
export class PropostaModule { }
