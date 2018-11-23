import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdubacaoEditComponent } from './adubacao-edit.component';

describe('AdubacaoEditComponent', () => {
  let component: AdubacaoEditComponent;
  let fixture: ComponentFixture<AdubacaoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdubacaoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdubacaoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
