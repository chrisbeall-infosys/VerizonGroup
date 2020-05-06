import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TravelerViewFlightComponent } from './traveler-view-flight.component';

describe('TravelerViewFlightComponent', () => {
  let component: TravelerViewFlightComponent;
  let fixture: ComponentFixture<TravelerViewFlightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TravelerViewFlightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TravelerViewFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
