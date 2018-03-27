import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { CadastroComponent } from './cadastro/cadastro.component';
import { ResultadoComponent } from './resultado/resultado.component';
import { PropostaRoutingModule } from './proposta-routing.module';
import {PropostaComponent} from './proposta.component';
import {SharedModule} from '../shared/shared.module';
import { AnaliseComponent } from './analise/analise.component';
import { AprovacaoCreditoComponent } from './modal/aprovacao-credito/aprovacao-credito.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    PropostaRoutingModule
  ],
  declarations: [PropostaComponent, CadastroComponent, ResultadoComponent, AnaliseComponent, AprovacaoCreditoComponent]
})
export class PropostaModule { }
