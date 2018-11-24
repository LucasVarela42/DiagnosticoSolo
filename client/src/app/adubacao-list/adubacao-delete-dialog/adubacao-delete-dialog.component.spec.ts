import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdubacaoDeleteDialogComponent } from './adubacao-delete-dialog.component';

describe('AdubacaoDeleteDialogComponent', () => {
  let component: AdubacaoDeleteDialogComponent;
  let fixture: ComponentFixture<AdubacaoDeleteDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdubacaoDeleteDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdubacaoDeleteDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
