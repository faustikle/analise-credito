import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../model/cliente/cliente';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders } from '@angular/common/http/src/headers';
import { AuthService } from '../../autenticacao/service/auth.service';

@Injectable()
export class ClienteService {

  resource = environment.apiClientes;

  constructor(
    private httpClient: HttpClient,
    private authService: AuthService,
    private router: Router,
  ) { }

  salvar(cliente: Cliente): Observable<Cliente> {
    const options = {
      withCredentials: true,
      headers: {
        'Authorization': 'Bearer ' + this.authService.getToken()
      }
    };

    return this.httpClient.post<Cliente>(this.resource, cliente, options);
  }
}
