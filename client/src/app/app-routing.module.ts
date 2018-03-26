import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PropostaRoutes}  from './proposta/proposta-routes.enum';
import { PrincipalComponent } from './principal/principal.component';
import { AutenticacaoRoutesEnum } from './autenticacao/autenticacao-routes.enum';
import { AuthGuard } from './autenticacao/service/auth.guard';

const routes: Routes = [
  {
    path: '',
    component: PrincipalComponent,
    canActivate: [AuthGuard]
  },
  {
    path: AutenticacaoRoutesEnum.AUTENTICACAO,
    loadChildren: 'app/autenticacao/autenticacao.module#AutenticacaoModule',
  },
  {
    path: 'principal',
    component: PrincipalComponent,
    canActivate: [AuthGuard]
  },
  {
    path: PropostaRoutes.PROPOSTA,
    loadChildren: 'app/proposta/proposta.module#PropostaModule',
    canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
