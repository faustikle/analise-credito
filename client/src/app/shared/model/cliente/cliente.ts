import {DadoPessoal} from './dado-pessoal';
import {DadoFinanceiro} from './dado-financeiro';

export class Cliente {
  id?: number;
  dadoPessoal?: DadoPessoal;
  dadoFinanceiro?: DadoFinanceiro;
}
