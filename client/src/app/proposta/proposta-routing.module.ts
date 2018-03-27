import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {PropostaComponent} from './proposta.component';
import {CadastroComponent} from './cadastro/cadastro.component';
import {ResultadoComponent} from './resultado/resultado.component';
import {PropostaRoutesEnum} from './proposta-routes.enum';
import {RoleGuard} from '../autenticacao/service/role-guard.service';
import {Papel} from '../autenticacao/enum/papel.enum';
import {AnaliseComponent} from './analise/analise.component';

const routes: Routes = [
  {
    path: '',
    component: PropostaComponent,
    children: [
      {
        path: PropostaRoutesEnum.CADASTRO,
        component: CadastroComponent,
        canActivate: [RoleGuard],
        data: { expectedRole: Papel.CAPTADOR_DE_PROPOSTA }
      },
      {
        path: PropostaRoutesEnum.RESULTADO,
        component: ResultadoComponent,
        canActivate: [RoleGuard],
        data: { expectedRole: Papel.CAPTADOR_DE_PROPOSTA }
      },
      {
        path: PropostaRoutesEnum.ANALISE,
        component: AnaliseComponent,
        canActivate: [RoleGuard],
        data: { expectedRole: Papel.ANALISTA_DE_CREDITO }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PropostaRoutingModule {}
