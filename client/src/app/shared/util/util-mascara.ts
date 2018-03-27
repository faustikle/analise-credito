import createNumberMask from 'text-mask-addons/dist/createNumberMask';

export class UtilMascara {
  public static getCpf(): Array<string|RegExp> {
    return [/\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '-', /\d/, /\d/];
  }

  public static getCnpj(): Array<string|RegExp> {
    return [/\d/, /\d/, '.', /\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '/', /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/];
  }

  public static getPhone(): Array<string|RegExp> {
    return ['(', /\d/, /\d/, ')', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/];
  }

  public static getCep(): Array<string|RegExp> {
    return [/\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/];
  }

  public static getDate(): Array<string|RegExp> {
    return [/\d/, /\d/, '/', /\d/, /\d/, '/', /\d/ , /\d/, /\d/, /\d/];
  }

  public static getHora(): Array<string|RegExp> {
    return [/\d/, /\d/, ':', /\d/, /\d/];
  }

  public static getUF(): Array<string|RegExp> {
    return [/\D/, /\D/];
  }

  public static getValorReal(): Array<string|RegExp> {
    return createNumberMask({
      prefix: 'R$',
      allowDecimal: true,
      decimalSymbol: ',',
      thousandsSeparatorSymbol: '.'
    });
  }
}
