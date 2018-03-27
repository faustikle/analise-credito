export enum PropostaRoutesEnum {
  PROPOSTA = 'proposta',
  CADASTRO = 'cadastro',
  RESULTADO = 'resultado',
  ANALISE = 'analise',
}

export function getRotaProposta(rota: string): string {
  const caminho: string[] = [];

  caminho[PropostaRoutesEnum.CADASTRO] = PropostaRoutesEnum.PROPOSTA + '/' + PropostaRoutesEnum.CADASTRO;
  caminho[PropostaRoutesEnum.RESULTADO] = PropostaRoutesEnum.PROPOSTA + '/' + PropostaRoutesEnum.RESULTADO;
  caminho[PropostaRoutesEnum.ANALISE] = PropostaRoutesEnum.PROPOSTA + '/' + PropostaRoutesEnum.ANALISE;

  return caminho[rota];
}
