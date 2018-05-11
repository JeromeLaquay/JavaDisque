import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { User } from '../../model/model.user';
import { ProduitCommandeService } from '../../services/produit-commande.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Panier } from '../../model/model.panier';
import { ProduitCommande } from '../../model/model.produit-commande';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class BasketComponent implements OnInit {
  produitsCommandes: ProduitCommande[] = [];
  errorMessage: String;
  currentUser: User;
  produitCommande: ProduitCommande = new ProduitCommande();
  
  constructor(private produitCommandeService :ProduitCommandeService,
    private route: ActivatedRoute,
    private router: Router) { 
}


  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.getPanier(); 
  }

  getPanier(){
    this.produitCommandeService.getByUser(this.currentUser.id)
      .subscribe(data => {
        this.produitsCommandes = data; }
      )
  }

  deleteCommande(id : string){
    this.produitCommandeService.deleteOne(id);
  }

  deleteCommande2(i : number){
    this.produitCommande = this.produitsCommandes[i];
    this.produitCommandeService.deleteOne(this.produitCommande.id);
  }

  deleteBasket(id : string){
    console.log("delete basket");
    this.produitCommandeService.deleteCommandeByBasket(this.currentUser.id);
  }
}
