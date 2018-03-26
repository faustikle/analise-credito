import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Proposta } from '../model/proposta';
import { Cliente } from '../../shared/model/cliente/cliente';

export class PropostaForm extends FormGroup {
  constructor() {
    super({
      cpf: new FormControl(
        null,
        [Validators.required]
      ),
      nome: new FormControl(
        null,
        [Validators.required]
      ),
      genero: new FormControl(
        null,
        [Validators.required]
      ),
      dataNascimento: new FormControl(
        null,
        [Validators.required]
      ),
      profissao: new FormControl(
        null,
        [Validators.required]
      ),
      rendaMensal: new FormControl(
        null,
        [Validators.required]
      ),
      cep: new FormControl(
        null,
        [Validators.required]
      ),
      cidade: new FormControl(
        null,
        [Validators.required]
      ),
      estado: new FormControl(
        null,
        [Validators.required]
      ),
      logradouro: new FormControl(
        null,
        [Validators.required]
      ),
      numero: new FormControl(
        null,
        [Validators.required]
      ),
      telefone: new FormControl(
        null,
        [Validators.required]
      )
    });
  }

  isValid(): boolean {
    return this.valid;
  }

  getCliente(): Cliente {
    return {
      dadoPessoal: {
        nome: this.get('nome').value,
        telefone: this.get('telefone').value.replace(new RegExp(/\D/, 'g'), ''),
        dataDeNascimento: this.get('dataNascimento').value.replace('/', '-'),
        cpf: {
          numero: this.get('cpf').value.replace(new RegExp(/\D/, 'g'), ''),
        },
        endereco: {
          cep: this.get('cep').value.replace(new RegExp(/\D/, 'g'), ''),
          cidade: this.get('cidade').value,
          estado: this.get('estado').value,
          logradouro: this.get('logradouro').value,
          numero: this.get('numero').value
        },
        genero: this.get('genero').value.value,
      },
      dadoFinanceiro: {
        profissao: this.get('profissao').value,
        rendaMensal: this.get('rendaMensal').value,
      }
    };
  }
}
