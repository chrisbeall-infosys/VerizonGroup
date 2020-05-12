import { TestBed } from '@angular/core/testing';

import { AdminViewAirportService } from './admin-view-airport.service';

describe('AdminViewAirportService', () => {
  let service: AdminViewAirportService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminViewAirportService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
