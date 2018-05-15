import { Injectable } from '@angular/core';
import {ProduitCommande} from "../model/model.produit-commande";
import {Http} from "@angular/http";
import {AppComponent} from "../app.component";
import { Observable } from 'rxjs/Observable';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable()
export class ProduitCommandeService {
  constructor(public http: Http, private router: Router) { }

  getAll(){
    return this.http.get(AppComponent.API_URL+'/produit-commande/all')
      .map(resp=>resp.json());
  }

  getOne(id: number){
    return this.http.get(AppComponent.API_URL+'/produit-commande/'+ id)
      .map(resp=>resp.json());
  }

  getByUser(id: string){
    return this.http.get(AppComponent.API_URL+'/produit-commande/user/'+ id)
      .map(resp=>resp.json());
  }

  deleteOne(id: string){
    return this.http.delete(AppComponent.API_URL+'/produit-commande/delete/'+ id);     
  }

  deleteCommandeByBasket(id: string){
    return this.http.delete(AppComponent.API_URL+'/produit-commande/delete/panier/'+ id)    
  }

  save(produitCommande: ProduitCommande){
    console.log(produitCommande);
    this.http.post(AppComponent.API_URL+'/produit-commande/save', produitCommande)
    .subscribe(res => {console.log(res);},
              err => {console.log("Error occured");}
    );
  }

  update(produitCommande: ProduitCommande){
    this.http.put(AppComponent.API_URL+'/produit-commande/update', JSON.stringify(produitCommande))
    .subscribe(res => {console.log(res);},
              err => {console.log("Error occured");}
    );
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private handleErrorObservable (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }
}
