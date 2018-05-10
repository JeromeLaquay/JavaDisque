import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { User } from '../../model/model.user';
import { PanierService } from '../../services/panier.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Panier } from '../../model/model.panier';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class BasketComponent implements OnInit {
  panier: Panier;
  errorMessage: String;
  currentUser: User;
  
  constructor(private panierService :PanierService,
    private route: ActivatedRoute,
    private router: Router) { 
}


  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.getPanier(); 
  }

  getPanier(){
    this.panierService.getOneByUser(this.currentUser.id)
      .subscribe(data => {
        this.panier = data; }
      )
  }

}
