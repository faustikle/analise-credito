import {AfterViewChecked, ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {PropostaService} from '../../shared/service/proposta.service';
import {Router} from '@angular/router';
import {LazyLoadEvent, SelectItem} from 'primeng/api';
import {UtilMascara} from '../../shared/util/util-mascara';
import {getDescricaoStatusProposta, Status} from '../enum/status.enum';
import {HttpParams} from '@angular/common/http';
import {Proposta} from '../model/proposta';
import {Pageable} from '../../shared/interface/pageable';
import {UtilMonetario} from '../../shared/util/util-monetario';
import {isNullOrUndefined} from 'util';
import {AlertComponent} from '../../shared/modal/alert/alert.component';

@Component({
  selector: 'app-resultado',
  templateUrl: './resultado.component.html',
  styleUrls: ['./resultado.component.scss']
})
export class ResultadoComponent implements OnInit, AfterViewChecked {

  @ViewChild('modalAlerta') modalAlerta: AlertComponent;

  exibirDataTable = false;
  loading = false;
  cpf: string;
  status: SelectItem;
  mascaraCpf = UtilMascara.getCpf();
  statusOptions: SelectItem[] = [
    {
      label: 'Todos',
      value: null
    },
    {
      label: getDescricaoStatusProposta(Status.EM_ANALISE),
      value: Status.EM_ANALISE
    },
    {
      label: getDescricaoStatusProposta(Status.NEGADA),
      value: Status.NEGADA
    },
    {
      label: getDescricaoStatusProposta(Status.APROVADA),
      value: Status.APROVADA
    }
  ];

  propostas: Proposta[] = [];
  totalPropostas: number;
  propostasPorPagina = 3;

  constructor(
    private changeDetectorRef: ChangeDetectorRef,
    private router: Router,
    private propostaService: PropostaService
  ) { }

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

    let parametros = new HttpParams();

    if (!!this.cpf) {
      const cpfFormatado = this.cpf.replace(new RegExp(/\D/, 'g'), '');
      parametros = parametros.set('cpf', cpfFormatado);
    }

    if (!!this.status && !!this.status.value) {
      const statusFormatado = this.status.value;
      parametros = parametros.set('status', statusFormatado);
    }

    parametros = parametros.set('page', page.toString()).set('sort', 'id').set('size', this.propostasPorPagina.toString());

    this.propostaService.pesquisar(parametros).subscribe(
      (pageable: Pageable<Proposta[]>) => {
        this.totalPropostas = pageable.totalElements;

        if (this.totalPropostas === 0) {
          this.modalAlerta.showDialog('Proposta', 'Nenhuma proposta encontrada!');
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
}
