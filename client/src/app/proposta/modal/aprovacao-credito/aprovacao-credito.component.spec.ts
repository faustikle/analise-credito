import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AprovacaoCreditoComponent } from './aprovacao-credito.component';

describe('AprovacaoCreditoComponent', () => {
  let component: AprovacaoCreditoComponent;
  let fixture: ComponentFixture<AprovacaoCreditoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AprovacaoCreditoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AprovacaoCreditoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
