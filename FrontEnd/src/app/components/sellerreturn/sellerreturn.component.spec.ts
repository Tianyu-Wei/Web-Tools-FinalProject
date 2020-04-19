import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerreturnComponent } from './sellerreturn.component';

describe('SellerreturnComponent', () => {
  let component: SellerreturnComponent;
  let fixture: ComponentFixture<SellerreturnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellerreturnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellerreturnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
