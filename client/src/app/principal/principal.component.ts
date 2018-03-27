import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import {getRotaProposta, PropostaRoutesEnum} from '../proposta/proposta-routes.enum';
import {AuthService} from '../autenticacao/service/auth.service';
import {Papel} from '../autenticacao/enum/papel.enum';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.scss']
})
export class PrincipalComponent implements OnInit {

  papel = Papel;

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit() {
  }

  hasPermissao(papel: string) {
    return this.authService.hasPapel(papel);
  }

  cadastrarProposta() {
    this.router.navigate([getRotaProposta(PropostaRoutesEnum.CADASTRO)]);
  }

  acompanharProposta() {
    this.router.navigate([getRotaProposta(PropostaRoutesEnum.RESULTADO)]);
  }

  analisarProposta() {
    this.router.navigate([getRotaProposta(PropostaRoutesEnum.ANALISE)]);
  }
}
