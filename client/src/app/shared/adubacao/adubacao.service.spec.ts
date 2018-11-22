import { TestBed } from '@angular/core/testing';

import { AdubacaoService } from './adubacao.service';

describe('AdubacaoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdubacaoService = TestBed.get(AdubacaoService);
    expect(service).toBeTruthy();
  });
});
