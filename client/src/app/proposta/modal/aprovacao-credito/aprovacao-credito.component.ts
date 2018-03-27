import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {Dialog} from 'primeng/dialog';
import {PropostaService} from '../../../shared/service/proposta.service';
import {Proposta} from '../../model/proposta';
import {UtilMascara} from '../../../shared/util/util-mascara';
import {UtilMonetario} from '../../../shared/util/util-monetario';

@Component({
  selector: 'app-aprovacao-credito',
  templateUrl: './aprovacao-credito.component.html',
  styleUrls: ['./aprovacao-credito.component.scss']
})
export class AprovacaoCreditoComponent {

  @ViewChild('dialog') public dialog: Dialog;
  @Output() emitExit: EventEmitter<boolean> = new EventEmitter();
  @Output() emitCancelar: EventEmitter<boolean> = new EventEmitter();

  visible = false;
  idProposta: number;
  credito: string;
  mascaraValor = UtilMascara.getValorReal();
  exibirErroCreditoNulo = false;
  loading = false;

  constructor(
    private propostaService: PropostaService
  ) { }

  showDialog(id: number): void {
    this.idProposta = id;
    this.visible = true;
  }

  aprovarProposta() {
    if (!this.credito) {
      this.exibirErroCreditoNulo = true;
      return;
    }

    this.exibirErroCreditoNulo = false;
    this.loading = true;
    const credito = this.credito.replace(new RegExp(/['R$ \.']/, 'g'), '').replace(',', '.');

    this.propostaService.aprovar(this.idProposta, parseInt(credito, 10)).subscribe(
      (propostaAprovada: Proposta) => {
        this.loading = false;
        this.limparCredito();
        this.close();
      },
      (erro) => {
        this.loading = false;
        this.limparCredito();
      }
    );
  }

  cancelar() {
    this.limparCredito();
    this.emitCancelar.emit(true);
    this.visible = false;
  }

  close(): void {
    this.emitExit.emit(true);
    this.visible = false;
  }

  private limparCredito() {
    this.credito = null;
  }
}
