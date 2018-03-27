import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { AuthService } from '../../autenticacao/service/auth.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Proposta } from '../../proposta/model/proposta';
import {Pageable} from '../interface/pageable';

@Injectable()
export class PropostaService {

  resource = environment.apiPropostas;

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

    return this.httpClient.post<Proposta>(this.resource + '/solicitar/' + clienteId, null, options);
  }

  pesquisar(parametros: HttpParams): Observable<Pageable<Proposta[]>> {
    const options = {
      withCredentials: true,
      headers: {
        'Authorization': 'Bearer ' + this.authService.getToken()
      },
      params: parametros
    };

    return this.httpClient.get<Pageable<Proposta[]>>(this.resource, options);
  }

  negar(id: number, motivo: string): Observable<Proposta> {
    const options = {
      withCredentials: true,
      headers: {
        'Authorization': 'Bearer ' + this.authService.getToken()
      }
    };

    return this.httpClient.put<Proposta>(this.resource + '/' + id + '/negar', { 'motivo': motivo } , options);
  }

  aprovar(id: number, credito: number): Observable<Proposta> {
    const options = {
      withCredentials: true,
      headers: {
        'Authorization': 'Bearer ' + this.authService.getToken()
      }
    };

    return this.httpClient.put<Proposta>(this.resource + '/' + id + '/aprovar', { 'credito': credito } , options);
  }
}
