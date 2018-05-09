import { TestBed, inject } from '@angular/core/testing';

import { ProduitCommandeService } from './produit-commande.service';

describe('PanierService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProduitCommandeService]
    });
  });

  it('should be created', inject([ProduitCommandeService], (service: ProduitCommandeService) => {
    expect(service).toBeTruthy();
  }));
});
