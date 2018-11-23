import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdubacaoDetailComponent } from './adubacao-detail.component';

describe('AdubacaoDetailComponent', () => {
  let component: AdubacaoDetailComponent;
  let fixture: ComponentFixture<AdubacaoDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdubacaoDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdubacaoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
