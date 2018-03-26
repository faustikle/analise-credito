import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

import { AuthService} from './auth.service';
import {AutenticacaoRoutesEnum, getRotaAutenticacao} from '../autenticacao-routes.enum';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this.authService.usuarioAutenticado()) {
      return true;
    }

    this.router.navigate([getRotaAutenticacao(AutenticacaoRoutesEnum.LOGIN)]);
    return false;
  }
}
