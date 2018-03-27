import {AfterViewChecked, ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {PropostaService} from '../../shared/service/proposta.service';
import {Router} from '@angular/router';
import {Proposta} from '../model/proposta';
import {HttpParams} from '@angular/common/http';
import {LazyLoadEvent} from 'primeng/api';
import {getDescricaoStatusProposta, Status} from '../enum/status.enum';
import {isNullOrUndefined} from "util";
import {UtilMonetario} from '../../shared/util/util-monetario';
import {Pageable} from '../../shared/interface/pageable';
import {AprovacaoCreditoComponent} from '../modal/aprovacao-credito/aprovacao-credito.component';

@Component({
  selector: 'app-analise',
  templateUrl: './analise.component.html',
  styleUrls: ['./analise.component.scss']
})
export class AnaliseComponent implements OnInit, AfterViewChecked {

  @ViewChild('modalAprovacaoCredito') modalAprovacaoCredito: AprovacaoCreditoComponent;

  loading = false;
  processando = false;
  exibirDataTable = false;
  propostas: Proposta[] = [];
  totalPropostas: number;
  propostasPorPagina = 5;

  constructor(
    private changeDetectorRef: ChangeDetectorRef,
    private router: Router,
    private propostaService: PropostaService
  ) {
    this.pesquisar();
  }

  ngOnInit() {
  }

  ngAfterViewChecked(): void {
    this.changeDetectorRef.detectChanges();
  }

  navegarTelaInicial() {
    this.router.navigate(['/']);
  }

  renovarDataTable() {
    this.exibirDataTable = false;
  }

  changePage(event: LazyLoadEvent): void {
    const pagina = event.first / event.rows;
    this.pesquisar(pagina);
  }

  pesquisar(page = 0) {
    this.loading = true;

    const parametros = new HttpParams().set('page', page.toString()).set('sort', 'id')
      .set('size', this.propostasPorPagina.toString()).set('status', Status.EM_ANALISE);

    this.propostaService.pesquisar(parametros).subscribe(
      (pageable: Pageable<Proposta[]>) => {
        this.totalPropostas = pageable.totalElements;

        if (this.totalPropostas === 0) {
          this.propostas = [];
          this.loading = false;
          return;
        }

        this.propostas = pageable.content;
        this.exibirDataTable = true;
        this.loading = false;
      },
      (error) => {
        this.loading = false;
      }
    );
  }

  getDescricaoStatus(status: string): string {
    return getDescricaoStatusProposta(status);
  }

  getCreditoFormatado(proposta: Proposta) {
    if (!isNullOrUndefined(proposta.resultado)) {
      return UtilMonetario.converterParaReal(proposta.resultado.credito.valor);
    }

    return null;
  }

  getCpfFormatado(cpf: string) {
    return !!cpf ? cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g, '\$1.\$2.\$3\-\$4') : null;
  }

  getRendaFormatada(renda: string) {
    return UtilMonetario.converterTextParaReal(renda);
  }

  negarProposta(proposta: Proposta) {
    this.processando = true;

    this.propostaService.negar(proposta.id, '').subscribe(
      (propostaAtualizada: Proposta) => {
        this.renovarDataTable();
        this.pesquisar();
        this.processando = false;
      },
      (erro) => {
        this.processando = false;
      }
    );
  }

  aprovarProposta(proposta: Proposta) {
    this.processando = true;
    this.modalAprovacaoCredito.showDialog(proposta.id);
  }

  cancelarAprovacao(event: boolean) {
    if (event) {
      this.processando = false;
    }
  }

  propostaAprovada(event: boolean) {
    if (event) {
      this.processando = false;
      this.pesquisar();
    }
  }
}
