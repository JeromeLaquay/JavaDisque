import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { User } from '../../model/model.user';
import { ProduitCommandeService } from '../../services/produit-commande.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Panier } from '../../model/model.panier';
import { ProduitCommande } from '../../model/model.produit-commande';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['../../app.component.css']
})
export class BasketComponent implements OnInit {
  produitsCommandes: ProduitCommande[] = [];
  errorMessage: String;
  currentUser: User;
  produitCommande: ProduitCommande = new ProduitCommande();
  prixTotal: number;
  
  constructor(private produitCommandeService :ProduitCommandeService,
    private authService :AuthService,
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
        this.produitsCommandes = data;
        this.calculPrixTotal();} 
      )
      
  }

  deleteCommande(i : number){
    this.produitCommande = this.produitsCommandes[i];
    this.produitCommandeService.deleteOne(this.produitCommande.id).subscribe(
      res => {window.location.reload(true);},
      err => {console.log("Error occured");}
    );
  }
    
  deleteBasket(id : string){
    this.produitCommandeService.deleteCommandeByBasket(this.currentUser.id).subscribe(
      res => {window.location.reload(true);},
      err => {console.log("Error occured");}
    );
  }

  logOut() {
    this.authService.logOut()
      .subscribe(
        data => {
          this.router.navigate(['/login']);
        },
        error => {

        });
  }

  calculPrixTotal(){
    this.prixTotal = 0;
    console.log("calcul du prix total");
    for(let comm of this.produitsCommandes){
      console.log(comm.quantite+ "      !!!!!!!!!!!");
      this.prixTotal += comm.produit.prix * comm.quantite;
    }
  }
}
