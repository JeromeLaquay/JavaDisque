import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { ProduitService } from '../../services/produit.service';
import { PanierService } from '../../services/panier.service';
import { ProduitCommandeService } from '../../services/produit-commande.service';
import { Produit } from '../../model/model.produit';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { ProduitCommande } from '../../model/model.produit-commande';
import { User } from '../../model/model.user';
import { Panier } from '../../model/model.panier';

@Component({
  selector: 'app-product-sheet',
  templateUrl: './product-sheet.component.html',
  styleUrls: ['./product-sheet.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProductSheetComponent implements OnInit {
  produit: Produit = new Produit();
  produitCommande: ProduitCommande = new ProduitCommande();
  errorMessage: string;
  id: number;
  currentUser: User;

  constructor(private produitService :ProduitService,
    private produitCommandeService :ProduitCommandeService,
    private panierService :PanierService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.produitCommande.panier = new Panier();
    this.produitCommande.produit = new Produit();
    this.getProduct();
    this.getPanier();
    this.produitCommande.quantite = 1;
  }

  getProduct(){
    let id = this.route.snapshot.paramMap.get('id');
    this.produitService.getOne(id)
      .subscribe(data => {
        this.produit = data;
        this.produitCommande.produit = data;
        console.log(this.produit.id + "  +++++");
       }
      )
  }

  addToBasket(){
    console.log("methode lancee");
    console.log(this.produitCommande.produit.title + "  "+ this.produitCommande.panier.id+"  "+this.produitCommande.quantite + "!!!!!!!!!");
    this.produitCommandeService.save(this.produitCommande);
    console.log("fait");
  }

  getPanier(){
    this.panierService.getOneByUser(this.currentUser.id)
      .subscribe(data => {
        this.produitCommande.panier = data; }
      )
  }
}
