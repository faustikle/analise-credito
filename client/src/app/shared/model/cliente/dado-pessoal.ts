import {Cpf} from './cpf';
import {Endereco} from './endereco';

export class DadoPessoal {
  nome?: string;
  genero?: string;
  telefone?: string;
  dataDeNascimento?: string;
  cpf?: Cpf;
  endereco?: Endereco;
}
