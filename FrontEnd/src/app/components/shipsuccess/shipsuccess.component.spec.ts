import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipsuccessComponent } from './shipsuccess.component';

describe('ShipsuccessComponent', () => {
  let component: ShipsuccessComponent;
  let fixture: ComponentFixture<ShipsuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShipsuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShipsuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
