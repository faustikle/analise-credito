export enum AutenticacaoRoutesEnum {
  AUTENTICACAO = 'autenticacao',
  LOGIN = 'login'
}

export function getRotaAutenticacao(rota: string): string {
  const caminho: string[] = [];

  caminho[AutenticacaoRoutesEnum.LOGIN] = AutenticacaoRoutesEnum.AUTENTICACAO + '/' + AutenticacaoRoutesEnum.LOGIN;

  return caminho[rota];
}
