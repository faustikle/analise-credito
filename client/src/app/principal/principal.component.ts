import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { getRotaProposta, PropostaRoutesEnum } from '../proposta/proposta-routes.enum';
import { AuthService } from '../autenticacao/service/auth.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.scss']
})
export class PrincipalComponent implements OnInit {

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }


  ngOnInit() {
  }

  cadastrarProposta() {
    this.router.navigate([getRotaProposta(PropostaRoutesEnum.CADASTRO)]);
  }

  analisarPropostas() {
    // rota analise
  }
}
