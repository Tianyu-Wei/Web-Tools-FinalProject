import { TestBed } from '@angular/core/testing';

import { CrudItemService } from './crud-item.service';

describe('CrudItemService', () => {
  let service: CrudItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CrudItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
