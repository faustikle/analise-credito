import {Cliente} from '../../shared/model/cliente/cliente';
import {Analisador} from './analisador';
import {Credito} from './credito';
import {Resultado} from './resultado';

export class Proposta {
  id?: number;
  cliente?: Cliente;
  resultado?: Resultado;
  status?: string;
}
