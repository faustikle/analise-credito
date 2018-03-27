import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Usuario } from '../model/usuario.model';

export class LoginForm extends FormGroup {
  constructor() {
    super({
      email: new FormControl(
        null,
        [Validators.required, Validators.email]
      ),
      senha: new FormControl(
        null,
        [Validators.required]
      )
    });
  }

  isValid(): boolean {
    return this.valid;
  }

  getUsuario(): Usuario {
    return {
      email: this.get('email').value,
      senha: this.get('senha').value
    };
  }
}

