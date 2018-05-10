import { Injectable } from '@angular/core';
import {Produit} from "../model/model.produit";
import {Http} from "@angular/http";
import {AppComponent} from "../app.component";

@Injectable()
export class ProduitService {
  constructor(public http: Http) { }

  getAll(){
    return this.http.get(AppComponent.API_URL+'/produit/all')
      .map(resp=>resp.json());
  }

  getOne(id: string){
    return this.http.get(AppComponent.API_URL+'/produit/'+ id)
      .map(resp=>resp.json());
  }
}
