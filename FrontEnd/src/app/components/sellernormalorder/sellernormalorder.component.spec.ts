import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellernormalorderComponent } from './sellernormalorder.component';

describe('SellernormalorderComponent', () => {
  let component: SellernormalorderComponent;
  let fixture: ComponentFixture<SellernormalorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellernormalorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellernormalorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
