import { Component, OnInit } from '@angular/core';

import { LoginForm } from './login.form';
import { AuthService } from '../service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: LoginForm = new LoginForm();
  loading = false;
  formSubmetido = false;

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    if (this.authService.usuarioAutenticado()) {
      this.router.navigate(['/']);
    }
  }

  async logar(): Promise<void> {
    this.formSubmetido = true;

    if (!this.loginForm.isValid()) {
      return;
    }

    this.loading = true;

    await this.authService.logar(this.loginForm.getUsuario());
    this.loading = false;
  }
}
