import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule } from '@angular/forms';
import { AuthService } from "./services/auth.service";
import {HttpModule} from "@angular/http";
import {AccountService} from "./services/account.service";
import {ProduitService} from "./services/produit.service";
import { ProfileComponent } from './components/profile/profile.component';
import {routing} from "./app.routing";
import {FacebookModule} from "ngx-facebook";
import {UrlPermission} from "./urlPermission/url.permission";
import { ListProductComponent } from './components/list-product/list-product.component';
import { ProductSheetComponent } from './components/product-sheet/product-sheet.component';
import { PaymentComponent } from './components/payment/payment.component';
import { BasketComponent } from './components/basket/basket.component';
import { ProduitCommandeService } from './services/produit-commande.service';
import { PanierService } from './services/panier.service';
import {BrowserAnimationsModule, NoopAnimationsModule} from '@angular/platform-browser/animations';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    ListProductComponent,
    ProductSheetComponent,
    PaymentComponent,
    BasketComponent,
  ],
  imports: [
    BrowserModule,BrowserAnimationsModule,NoopAnimationsModule,HttpModule,FormsModule,routing, FacebookModule.forRoot(),
  ],
  providers: [AuthService,AccountService,ProduitService,ProduitCommandeService, PanierService,UrlPermission],
  bootstrap: [AppComponent]
})
export class AppModule { }
