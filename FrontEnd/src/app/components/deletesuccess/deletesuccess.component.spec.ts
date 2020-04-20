import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletesuccessComponent } from './deletesuccess.component';

describe('DeletesuccessComponent', () => {
  let component: DeletesuccessComponent;
  let fixture: ComponentFixture<DeletesuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeletesuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletesuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
