import {Produit} from "../model/model.produit";
import { Panier } from "./model.panier";

export class ProduitCommande {
  id : string;
  produit: Produit;
  quantite: number;
  panier: Panier;
}
