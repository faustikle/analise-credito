export enum Papel {
  CAPTADOR_DE_PROPOSTA = 'CAPTADOR_DE_PROPOSTA',
  ANALISTA_DE_CREDITO = 'ANALISTA_DE_CREDITO'
}

export function getDescricaoPapelUsuario(papelAtual: string): string {
  const papeis: string[] = [];

  papeis[Papel.CAPTADOR_DE_PROPOSTA] = 'Captador de Proposta';
  papeis[Papel.ANALISTA_DE_CREDITO] = 'Analista de Crédito';

  return papeis[papelAtual];
}
