import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {PropostaRoutes} from './proposta/proposta-routes.enum';
import {PrincipalComponent} from './principal/principal.component';
import {AutenticacaoRoutesEnum} from './autenticacao/autenticacao-routes.enum';

const routes: Routes = [
  {
    path: '',
    component: PrincipalComponent,
  },
  {
    path: AutenticacaoRoutesEnum.AUTENTICACAO,
    loadChildren: 'app/autenticacao/autenticacao.module#AutenticacaoModule',
  },
  {
    path: 'principal',
    component: PrincipalComponent,
  },
  {
    path: PropostaRoutes.PROPOSTA,
    loadChildren: 'app/proposta/proposta.module#PropostaModule',
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
