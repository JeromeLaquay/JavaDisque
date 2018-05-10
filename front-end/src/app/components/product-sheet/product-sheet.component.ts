import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ProduitService } from '../../services/produit.service';
import { PanierService } from '../../services/panier.service';
import { ProduitCommandeService } from '../../services/produit-commande.service';
import { Produit } from '../../model/model.produit';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { ProduitCommande } from '../../model/model.produit-commande';
import { User } from '../../model/model.user';

@Component({
  selector: 'app-product-sheet',
  templateUrl: './product-sheet.component.html',
  styleUrls: ['./product-sheet.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProductSheetComponent implements OnInit {
  produit: Produit;
  produitCommande: ProduitCommande;
  errorMessage: string;
  id: number;
  currentUser = User;

  constructor(private produitService :ProduitService,
    private produitCommandeService :ProduitCommandeService,
    private panierService :PanierService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    let id = this.route.snapshot.paramMap.get('id');
    this.getProduct(id);
  }

  getProduct(id: string){
    this.produitService.getOne(id)
      .subscribe(data => {
        this.produit = data; }
      )
  }

  addToBasket(){
    this.produitCommande.produit = this.produit;
    this.produitCommande.quantite = 1;
    this.getPanier();
    this.produitCommandeService.save(this.produitCommande)
      .subscribe(err=>{
        this.errorMessage="error :  ";
        }
      )
  }

  getPanier(){
    this.panierService.getOneByUser(this.currentUser.id)
      .subscribe(data => {
        this.produitCommande.panier = data; }
      )
  }
}
