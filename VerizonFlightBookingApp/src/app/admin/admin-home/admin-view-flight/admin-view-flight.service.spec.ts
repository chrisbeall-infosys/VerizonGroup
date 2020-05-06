import { TestBed } from '@angular/core/testing';

import { AdminViewFlightService } from './admin-view-flight.service';

describe('AdminViewFlightService', () => {
  let service: AdminViewFlightService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminViewFlightService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
