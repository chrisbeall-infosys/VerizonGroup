import { TestBed } from '@angular/core/testing';

import { AddAirportService } from './add-airport.service';

describe('AddAirportService', () => {
  let service: AddAirportService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddAirportService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
