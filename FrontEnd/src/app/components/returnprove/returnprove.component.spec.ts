import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReturnproveComponent } from './returnprove.component';

describe('ReturnproveComponent', () => {
  let component: ReturnproveComponent;
  let fixture: ComponentFixture<ReturnproveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReturnproveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReturnproveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
