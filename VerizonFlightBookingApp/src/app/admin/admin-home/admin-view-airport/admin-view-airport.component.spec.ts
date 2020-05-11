import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewAirportComponent } from './admin-view-airport.component';

describe('AdminViewAirportComponent', () => {
  let component: AdminViewAirportComponent;
  let fixture: ComponentFixture<AdminViewAirportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminViewAirportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminViewAirportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
