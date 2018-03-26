import {DadoPessoal} from './dado-pessoal';
import {DadoFinanceiro} from './dado-financeiro';

export class Cliente {
  dadoPessoal?: DadoPessoal;
  telefone?: string;
  dataDeNascimento?: string;
  dadoFinanceiro?: DadoFinanceiro;
}
