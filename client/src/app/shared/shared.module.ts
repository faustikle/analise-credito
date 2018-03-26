import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CardModule} from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { CalendarModule, DropdownModule, InputTextModule } from 'primeng/primeng';
import { TextMaskModule } from 'angular2-text-mask';
import { ClienteService } from './service/cliente.service';


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
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    CardModule,
    ButtonModule,
    InputTextModule,
    DropdownModule,
    CalendarModule,
    TextMaskModule
  ],
  providers: [ClienteService],
  declarations: []
})
export class SharedModule { }
