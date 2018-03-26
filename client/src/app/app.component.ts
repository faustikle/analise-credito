import { Component } from '@angular/core';
import { AuthService } from './autenticacao/service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(
    private authService: AuthService
  ) {}

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
