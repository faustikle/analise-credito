import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {CardModule} from 'primeng/card';
import {ButtonModule} from 'primeng/button';
import {CalendarModule, DataTableModule, DropdownModule, InputTextModule} from 'primeng/primeng';
import {TextMaskModule} from 'angular2-text-mask';
import {ClienteService} from './service/cliente.service';
import {PropostaService} from './service/proposta.service';
import { AlertComponent } from './modal/alert/alert.component';
import {DialogModule} from 'primeng/dialog';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CardModule,
    ButtonModule,
    InputTextModule,
    DropdownModule,
    CalendarModule,
    TextMaskModule,
    DialogModule,
    DataTableModule
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    CardModule,
    ButtonModule,
    InputTextModule,
    DropdownModule,
    CalendarModule,
    TextMaskModule,
    DialogModule,
    AlertComponent,
    DataTableModule
  ],
  providers: [ClienteService, PropostaService],
  declarations: [AlertComponent]
})
export class SharedModule { }
