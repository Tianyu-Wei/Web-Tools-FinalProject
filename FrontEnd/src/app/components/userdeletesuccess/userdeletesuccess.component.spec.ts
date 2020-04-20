import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserdeletesuccessComponent } from './userdeletesuccess.component';

describe('UserdeletesuccessComponent', () => {
  let component: UserdeletesuccessComponent;
  let fixture: ComponentFixture<UserdeletesuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserdeletesuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserdeletesuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
