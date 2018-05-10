import { Injectable } from '@angular/core';
import {Panier} from "../model/model.panier";
import {Http} from "@angular/http";
import {AppComponent} from "../app.component";

@Injectable()
export class PanierService {
  constructor(public http: Http) { }

  getAll(){
    return this.http.get(AppComponent.API_URL+'/panier/all')
      .map(resp=>resp.json());
  }

  getOne(id: number){
    return this.http.get(AppComponent.API_URL+'/panier/'+ id)
      .map(resp=>resp.json());
  }

  save(panier: Panier){
    return this.http.post(AppComponent.API_URL+'/panier/save', panier);
  }

  update(panier: Panier){
    return this.http.put(AppComponent.API_URL+'/panier/update', panier);
  }

  getOneByUser(id: string){
    return this.http.get(AppComponent.API_URL+'/panier/user/'+ id)
      .map(resp=>resp.json());
  }
}
