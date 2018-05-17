import { Component, OnInit, ViewEncapsulation} from '@angular/core';
import { ProduitService } from '../../services/produit.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Produit } from '../../model/model.produit';
import { User } from '../../model/model.user';
import {MatTableDataSource} from '@angular/material';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['../../app.component.css']
})
export class ListProductComponent implements OnInit {
  produits: Produit[] = [];
  errorMessage: String;
  currentUser: User;

  constructor(private produitService :ProduitService,
              private authService :AuthService,
              private route: ActivatedRoute,
              private router: Router) { 
  }
  
  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.getAllProducts(); 
  }

  getAllProducts(){
    this.produitService.getAll()
      .subscribe(data => {
        this.produits = data; }
      )
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
}
