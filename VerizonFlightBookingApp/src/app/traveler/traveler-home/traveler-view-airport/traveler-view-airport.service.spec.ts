import { TestBed } from '@angular/core/testing';

import { TravelerViewAirportService } from './traveler-view-airport.service';

describe('TravelerViewAirportService', () => {
  let service: TravelerViewAirportService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TravelerViewAirportService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
