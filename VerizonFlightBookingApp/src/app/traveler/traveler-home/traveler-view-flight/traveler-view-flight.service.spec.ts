import { TestBed } from '@angular/core/testing';

import { TravelerViewFlightService } from './traveler-view-flight.service';

describe('TravelerViewFlightService', () => {
  let service: TravelerViewFlightService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TravelerViewFlightService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
