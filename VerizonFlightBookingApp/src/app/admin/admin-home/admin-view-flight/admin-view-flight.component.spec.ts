import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewFlightComponent } from './admin-view-flight.component';

describe('AdminViewFlightComponent', () => {
  let component: AdminViewFlightComponent;
  let fixture: ComponentFixture<AdminViewFlightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminViewFlightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminViewFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
