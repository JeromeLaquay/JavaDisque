import { Component, OnInit, ViewEncapsulation} from '@angular/core';
import { ProduitService } from '../../services/produit.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Produit } from '../../model/model.produit';
import { User } from '../../model/model.user';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ListProductComponent implements OnInit {
  produits: Produit[] = [];
  errorMessage: String;
  currentUser: User;

  constructor(private produitService :ProduitService,
              private route: ActivatedRoute,
              private router: Router) { 
  }

  
  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.getAllProducts(); 
  }

  getAllProducts(){
    this.produitService.getAll()
      .subscribe(data => {
        this.produits = data; }
      )
  }
}
