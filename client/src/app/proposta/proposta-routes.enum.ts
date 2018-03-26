export enum PropostaRoutesEnum {
  PROPOSTA = 'proposta',
  CADASTRO = 'cadastro',
  RESULTADO = 'resultado'
}

export function getRotaProposta(rota: string): string {
  const caminho: string[] = [];

  caminho[PropostaRoutesEnum.CADASTRO] = PropostaRoutesEnum.PROPOSTA + '/' + PropostaRoutesEnum.CADASTRO;
  caminho[PropostaRoutesEnum.RESULTADO] = PropostaRoutesEnum.PROPOSTA + '/' + PropostaRoutesEnum.RESULTADO;

  return caminho[rota];
}
