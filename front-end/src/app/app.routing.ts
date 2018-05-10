import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {ListProductComponent} from "./components/list-product/list-product.component";
import {UrlPermission} from "./urlPermission/url.permission";
import { PaymentComponent } from './components/payment/payment.component';
import { BasketComponent } from './components/basket/basket.component';
import { ProductSheetComponent } from './components/product-sheet/product-sheet.component';


const appRoutes: Routes = [
  { path: 'profile', component: ProfileComponent ,canActivate: [UrlPermission] },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'list-product', component: ListProductComponent ,canActivate: [UrlPermission]},
  { path: 'product-sheet/:id', component: ProductSheetComponent ,canActivate: [UrlPermission]},
  { path: 'basket', component: BasketComponent ,canActivate: [UrlPermission]},
  { path: 'payment', component: PaymentComponent ,canActivate: [UrlPermission]},

  // otherwise redirect to profile
  { path: '**', redirectTo: '/login' }
];

export const routing = RouterModule.forRoot(appRoutes);
