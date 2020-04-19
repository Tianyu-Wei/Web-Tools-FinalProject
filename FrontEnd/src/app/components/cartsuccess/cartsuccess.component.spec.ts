import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CartsuccessComponent } from './cartsuccess.component';

describe('CartsuccessComponent', () => {
  let component: CartsuccessComponent;
  let fixture: ComponentFixture<CartsuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CartsuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CartsuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
