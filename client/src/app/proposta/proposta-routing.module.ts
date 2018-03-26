import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import { PropostaComponent } from './proposta.component';
import { PropostaRoutesEnum } from './proposta-routes.enum';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ResultadoComponent } from './resultado/resultado.component';

const routes: Routes = [
  {
    path: '',
    component: PropostaComponent,
    children: [
      {
        path: PropostaRoutesEnum.CADASTRO,
        component: CadastroComponent,
      },
      {
        path: PropostaRoutesEnum.RESULTADO,
        component: ResultadoComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PropostaRoutingModule {}
