import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdubacaoAddComponent } from './adubacao-add.component';

describe('AdubacaoAddComponent', () => {
  let component: AdubacaoAddComponent;
  let fixture: ComponentFixture<AdubacaoAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdubacaoAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdubacaoAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
