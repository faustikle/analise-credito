import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {PropostaRoutes} from './proposta/proposta-routes.enum';
import {PrincipalComponent} from './principal/principal.component';

const routes: Routes = [
  {
    path: '',
    component: PrincipalComponent,
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
