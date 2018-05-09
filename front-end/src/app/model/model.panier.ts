import {User} from "../model/model.user";
import {ProduitCommande} from "../model/model.Produit-commande";

export class Panier {
  id : string;
  prixTotal: number;
  produitsCommandes: ProduitCommande[];
  user: User;
}
