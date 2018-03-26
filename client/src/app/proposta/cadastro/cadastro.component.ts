import { Component, OnInit } from '@angular/core';

import { PropostaForm } from './proposta.form';
import { SelectItem } from 'primeng/api';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {

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

  constructor() { }

  ngOnInit() {
  }

}
