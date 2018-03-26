import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../../autenticacao/service/auth.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Proposta } from '../model/proposta';

@Injectable()
export class PropostaService {

  resource = environment.apiPropostas + '/solicitar/';

  constructor(
    private httpClient: HttpClient,
    private authService: AuthService,
    private router: Router,
  ) { }

  solicitar(clienteId: number): Observable<Proposta> {
    const options = {
      withCredentials: true,
      headers: {
        'Authorization': 'Bearer ' + this.authService.getToken()
      }
    };

    return this.httpClient.post<Proposta>(this.resource + clienteId, null, options);
  }
}
