import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AutenticacaoComponent } from './autenticacao.component';
import { AutenticacaoRoutesEnum } from './autenticacao-routes.enum';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: '',
    component: AutenticacaoComponent,
    children: [
      {
        path: AutenticacaoRoutesEnum.LOGIN,
        component: LoginComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AutenticacaoRoutingModule {}
