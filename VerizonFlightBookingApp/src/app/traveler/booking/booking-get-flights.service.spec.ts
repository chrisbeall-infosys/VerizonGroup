import { TestBed } from '@angular/core/testing';

import { BookingGetFlightsService } from './booking-get-flights.service';

describe('BookingGetFlightsService', () => {
  let service: BookingGetFlightsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookingGetFlightsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
