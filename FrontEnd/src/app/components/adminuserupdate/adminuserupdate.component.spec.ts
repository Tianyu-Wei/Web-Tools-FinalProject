import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminuserupdateComponent } from './adminuserupdate.component';

describe('AdminuserupdateComponent', () => {
  let component: AdminuserupdateComponent;
  let fixture: ComponentFixture<AdminuserupdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminuserupdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminuserupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
