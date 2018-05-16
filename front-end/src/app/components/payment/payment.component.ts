import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProduitCommandeService } from '../../services/produit-commande.service';
import { ProduitCommande } from '../../model/model.produit-commande';
import { User } from '../../model/model.user';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  produitsCommandes: ProduitCommande[] = [];
  errorMessage: String;
  currentUser: User;
  prixTotal: number;

  constructor(private produitCommandeService :ProduitCommandeService,
    private authService :AuthService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.getPanier();
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

  getPanier(){
    this.produitCommandeService.getByUser(this.currentUser.id)
      .subscribe(data => {
        this.produitsCommandes = data;
        this.calculPrixTotal();} 
      )
      
  }

  calculPrixTotal(){
    this.prixTotal = 0;
    console.log("calcul du prix total");
    for(let comm of this.produitsCommandes){
      console.log(comm.quantite);
      this.prixTotal += comm.produit.prix * comm.quantite;
    }
  }

}
