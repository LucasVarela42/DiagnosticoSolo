import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdubacaoListComponent } from './adubacao-list.component';

describe('AdubacaoListComponent', () => {
  let component: AdubacaoListComponent;
  let fixture: ComponentFixture<AdubacaoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdubacaoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdubacaoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
