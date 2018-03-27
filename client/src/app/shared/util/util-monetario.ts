import * as currenty from 'currency-formatter';

export class UtilMonetario {
  static converterParaReal(valor: number) {
    return currenty.format(valor, { locale: 'pt-BR'});
  }

  static converterTextParaReal(valor: string) {
    return currenty.format(valor, { locale: 'pt-BR'});
  }
}
