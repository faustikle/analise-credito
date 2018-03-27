import {Component, EventEmitter, Output, ViewChild} from '@angular/core';
import { Dialog } from 'primeng/dialog';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss']
})
export class AlertComponent {

  @ViewChild('dialog') public dialog: Dialog;
  @Output() emitExit: EventEmitter<boolean> = new EventEmitter();

  visible = false;
  titulo: string;
  descricao: string;

  constructor() { }

  showDialog(titulo: string, descricao: string): void {
    this.titulo = titulo;
    this.descricao = descricao;
    this.visible = true;
  }

  close(): void {
    this.emitExit.emit(true);
    this.visible = false;
  }
}
