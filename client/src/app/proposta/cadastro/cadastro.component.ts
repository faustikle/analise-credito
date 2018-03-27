import {Component, OnInit, ViewChild} from '@angular/core';

import { PropostaForm } from './proposta.form';
import { SelectItem } from 'primeng/api';
import { Router } from '@angular/router';
import { UtilMascara } from '../../shared/util/util-mascara';
import { ClienteService } from '../../shared/service/cliente.service';
import { Cliente } from '../../shared/model/cliente/cliente';
import { PropostaService } from '../../shared/service/proposta.service';
import { Proposta } from '../model/proposta';
import { AlertComponent } from '../../shared/modal/alert/alert.component';
import { getDescricaoStatusProposta } from '../enum/status.enum';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {

  @ViewChild('modalAlerta') modalAlerta: AlertComponent;

  loading = false;
  formSubmetido = false;
  mascaraCpf = UtilMascara.getCpf();
  mascaraTelefone = UtilMascara.getPhone();
  mascaraCep = UtilMascara.getCep();
  mascaraUF = UtilMascara.getUF();
  mascaraValor = UtilMascara.getValorReal();
  propostaForm: PropostaForm = new PropostaForm();
  generos: SelectItem[] = [
    {
      label: 'Masculino',
      value: 'MASCULINO'
    },
    {
      label: 'Feminino',
      value: 'FEMININO'
    }
  ];
  configPtBrCalendar: object = {
    firstDayOfWeek: 0,
    dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
    dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
    dayNamesMin: ['Do', 'Se', 'Te', 'Qa', 'Qi', 'Sx', 'Sa'],
    monthNames: [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
      'Julho', 'Augusto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
    monthNamesShort: [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    today: 'Hoje',
    clear: 'Limpar'
  };

  constructor(
    private router: Router,
    private clienteService: ClienteService,
    private propostaService: PropostaService
  ) { }

  ngOnInit() {
  }

  navegarTelaInicial() {
    this.router.navigate(['/']);
  }

  cadastrar() {
    this.formSubmetido = true;

    if (!this.propostaForm.isValid()) {
      return;
    }

    this.loading = true;

    this.clienteService.salvar(this.propostaForm.getCliente()).subscribe(
      (cliente: Cliente) => {
        this.propostaService.solicitar(cliente.id).subscribe(
          (proposta: Proposta) => {
            this.modalAlerta.showDialog('Proposta cadastrada!', 'Status: ' + getDescricaoStatusProposta(proposta.status));
            this.loading = false;
          },
          (erro) => {
            this.loading = false;
          }
        );
      },
      (erro) => {
        this.loading = false;
      }
    );
  }

  finalizarCadastro(event: boolean) {
    if (event) {
      this.navegarTelaInicial();
    }
  }
}
