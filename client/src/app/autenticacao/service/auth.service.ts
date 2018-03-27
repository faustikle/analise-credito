import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Router } from '@angular/router';

import { JwtHelper } from 'angular2-jwt';
import { Usuario } from '../model/usuario.model';
import { AutenticacaoRoutesEnum, getRotaAutenticacao } from '../autenticacao-routes.enum';

@Injectable()
export class AuthService {

  resource = environment.apiAuth + '/token';
  private storage: Storage = sessionStorage;
  private jwtHelper: JwtHelper = new JwtHelper();

  constructor(
    private httpClient: HttpClient,
    private router: Router,
  ) { }

  logar(usuario: Usuario): Promise<any> {
    return this.httpClient.post<any>(this.resource, usuario).toPromise()
      .then((response) => {
        this.salvarStorage(response.token);
        window.location.href = '/';
        Promise.resolve();
      })
      .catch();
  }

  usuarioAutenticado(): boolean {
    const token = this.getToken();

    return token && !this.jwtHelper.isTokenExpired(token);
  }

  deslogar(): void {
    this.limparSessionStorage();
    this.router.navigate([getRotaAutenticacao(AutenticacaoRoutesEnum.LOGIN)]);
  }

  getToken(): string {
    return this.storage.getItem('token');
  }

  getPapel() {
    return this.storage.getItem('userrole');
  }

  hasPapel(papel: string): boolean {
    return papel === this.getPapel();
  }

  private salvarStorage(token: string): void {
    this.storage.setItem('token', token);

    const payload = this.decodeToken(token);
    this.storage.setItem('useremail', payload.sub);
    this.storage.setItem('userid', payload.id);
    this.storage.setItem('username', payload.nome);
    this.storage.setItem('userrole', payload.papel);
  }

  getUsuarioLogado(): Usuario {
    return {
      id: parseInt(this.storage.getItem('userid'), 10),
      nome: this.storage.getItem('username'),
      papel: this.storage.getItem('userrole'),
      email: this.storage.getItem('useremail'),
    };
  }

  private decodeToken(token: string): any {
    return this.jwtHelper.decodeToken(token);
  }

  private limparSessionStorage(): void {
    this.storage.removeItem('token');
    this.storage.removeItem('useremail');
    this.storage.removeItem('userid');
    this.storage.removeItem('username');
    this.storage.removeItem('userrole');
  }
}
