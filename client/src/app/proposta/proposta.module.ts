import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { CadastroComponent } from './cadastro/cadastro.component';
import { ResultadoComponent } from './resultado/resultado.component';
import { PropostaRoutingModule } from './proposta-routing.module';
import { PropostaComponent } from './proposta.component';
import { SharedModule } from '../shared/shared.module';
import { PropostaService } from './service/proposta.service';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    PropostaRoutingModule
  ],
  providers: [PropostaService],
  declarations: [PropostaComponent, CadastroComponent, ResultadoComponent]
})
export class PropostaModule { }
