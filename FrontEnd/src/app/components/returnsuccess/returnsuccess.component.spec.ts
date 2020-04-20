import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReturnsuccessComponent } from './returnsuccess.component';

describe('ReturnsuccessComponent', () => {
  let component: ReturnsuccessComponent;
  let fixture: ComponentFixture<ReturnsuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReturnsuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReturnsuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
