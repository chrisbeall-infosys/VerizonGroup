import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelerViewAirportComponent } from './traveler-view-airport.component';

describe('TravelerViewAirportComponent', () => {
  let component: TravelerViewAirportComponent;
  let fixture: ComponentFixture<TravelerViewAirportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelerViewAirportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelerViewAirportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
