import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LaudoEditComponent } from './laudo-edit.component';

describe('LaudoEditComponent', () => {
  let component: LaudoEditComponent;
  let fixture: ComponentFixture<LaudoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LaudoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LaudoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
