import { Component } from '@angular/core';
import { AuthService } from './autenticacao/service/auth.service';
import { getDescricaoPapelUsuario, Papel } from './autenticacao/enum/papel.enum';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  usuario: Usuario;

  constructor(
    public authService: AuthService
  ) {}

  getPapelUsuario() {
    return getDescricaoPapelUsuario(this.authService.getPapel());
  }

  usuarioLogado() {
    return this.authService.usuarioAutenticado();
  }

  usuarioNaoLogado() {
    return !this.authService.usuarioAutenticado();
  }

  deslogar() {
    this.authService.deslogar();
  }
}
