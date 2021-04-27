import { TestBed } from '@angular/core/testing';

import { MycarsService } from './mycars.service';

describe('MycarsService', () => {
  let service: MycarsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MycarsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
