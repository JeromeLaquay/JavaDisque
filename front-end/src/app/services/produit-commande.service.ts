import { Injectable } from '@angular/core';
import {ProduitCommande} from "../model/model.produit-commande";
import {Http} from "@angular/http";
import {AppComponent} from "../app.component";

@Injectable()
export class ProduitCommandeService {
  constructor(public http: Http) { }

  getAll(){
    return this.http.get(AppComponent.API_URL+'/produit-commande/all')
      .map(resp=>resp.json());
  }

  getOne(id: number){
    return this.http.get(AppComponent.API_URL+'/produit-commande/'+ id)
      .map(resp=>resp.json());
  }

  deleteOne(id: number){
    return this.http.delete(AppComponent.API_URL+'/produit-commande/delete/'+ id);     
  }

  deleteCommandeByBasket(id: number){
    return this.http.delete(AppComponent.API_URL+'/produit-commande/delete/panier/'+ id);     
  }

  save(produitCommande: ProduitCommande){
    return this.http.post(AppComponent.API_URL+'/produit-commande/save', produitCommande);
  }

  update(produitCommande: ProduitCommande){
    return this.http.put(AppComponent.API_URL+'/produit-commande/update', produitCommande);
  }
}
