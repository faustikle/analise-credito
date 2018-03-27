
export enum Status {
  EM_ANALISE = 'EM_ANALISE',
  APROVADA = 'APROVADA',
  NEGADA = 'NEGADA'
}

export function getDescricaoStatusProposta(statusAtual: string): string {
  const status: string[] = [];

  status[Status.EM_ANALISE] = 'Em Análise';
  status[Status.APROVADA] = 'Aprovada';
  status[Status.NEGADA] = 'Negada';

  return status[statusAtual];
}
