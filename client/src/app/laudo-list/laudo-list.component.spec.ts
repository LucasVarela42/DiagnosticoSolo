import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LaudoListComponent } from './laudo-list.component';

describe('LaudoListComponent', () => {
  let component: LaudoListComponent;
  let fixture: ComponentFixture<LaudoListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LaudoListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LaudoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
