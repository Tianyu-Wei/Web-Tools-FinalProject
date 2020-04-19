import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { SearchdetailComponent } from './components/searchdetail/searchdetail.component';
import { SearchresultsComponent } from './components/searchresults/searchresults.component';
import { AuthComponent } from './components/auth/auth.component';
import { UserdetailComponent } from './components/userdetail/userdetail.component';
import { ErrorComponent } from './components/error/error.component';
import { HomeComponent } from './components/home/home.component';
import { CategoryComponent } from './components/category/category.component';
import { CategoryDetailComponent } from './components/category-detail/category-detail.component';
import { SellerPanelComponent } from './components/seller-panel/seller-panel.component';
import { SelectRoleComponent } from './components/select-role/select-role.component';
import { SellerProductComponent } from './components/seller-product/seller-product.component';
import { UpdateItemComponent } from './components/update-item/update-item.component';
import { CreateItemComponent } from './components/create-item/create-item.component';
import { CartComponent } from './components/cart/cart.component';
import { OrdersuccessComponent } from './components/ordersuccess/ordersuccess.component';
import { CartsuccessComponent } from './components/cartsuccess/cartsuccess.component';
import { OrdermanageComponent } from './components/ordermanage/ordermanage.component';
import { AdmincreateuserComponent } from './components/admincreateuser/admincreateuser.component';
import { AdminuserComponent } from './components/adminuser/adminuser.component';
import { AdminpanelComponent } from './components/adminpanel/adminpanel.component';
import { SellernormalorderComponent } from './components/sellernormalorder/sellernormalorder.component';
import { SellerreturnComponent } from './components/sellerreturn/sellerreturn.component';
import { ShiporderComponent } from './components/shiporder/shiporder.component';
import { CancelorderComponent } from './components/cancelorder/cancelorder.component';
import { SellerorderComponent } from './components/sellerorder/sellerorder.component';


const routes: Routes = [
  {path: '', redirectTo: '/home/no/no/no', pathMatch: 'full'},
  {path: 'home/:username/:auth/:role', component: HomeComponent},
  {path: 'search/:category/:keyword/:username/:auth/:role', component: SearchresultsComponent},
  {path: 'detail/:id/:username/:auth/:role', component: SearchdetailComponent},
  {path: 'select/:username/:auth/:role', component: SelectRoleComponent},
  {path: 'auth/:username/:auth/:role', component: AuthComponent},
  {path: 'userdetail/:username/:auth/:role', component: UserdetailComponent},
  {path: 'error/:username/:auth/:role', component: ErrorComponent},
  {path: 'category/:username/:auth/:role', component: CategoryComponent},
  {path: 'categorydetail/:cate/:username/:auth/:role', component: CategoryDetailComponent},
  {path: 'seller/:username/:auth/:role', component: SellerPanelComponent},
  {path: 'seller/manageproduct/:username/:auth/:role', component: SellerProductComponent},
  {path: 'updateitem/:id/:username/:auth/:role', component: UpdateItemComponent},
  {path: 'createitem/:username/:auth/:role', component: CreateItemComponent},
  {path: 'cart/:username/:auth/:role', component: CartComponent},
  {path: 'ordersuccess/:username/:auth/:role', component: OrdersuccessComponent},
  {path: 'cartsuccess/:username/:auth/:role', component: CartsuccessComponent},
  {path: 'order/:username/:auth/:role', component: OrdermanageComponent},
  {path: 'adminproduct/:username/:auth/:role', redirectTo: 'seller/manageproduct/:username/:auth/:role', pathMatch: 'full'},
  {path: 'adminuser/:username/:auth/:role', component: AdminuserComponent},
  {path: 'admincreateuser/:username/:auth/:role', component: AdmincreateuserComponent},
  {path: 'admin/:username/:auth/:role', component: AdminpanelComponent},
  {path: 'seller/orders/:username/:auth/:role', component: SellernormalorderComponent},
  {path: 'seller/orders/return/:username/:auth/:role', component: SellerreturnComponent},
  {path: 'shiporder/:username/:ordernum/:sellername/:auth/:role', component: ShiporderComponent},
  {path: 'cancelorder/:username/:ordernum/:sellername/:auth/:role', component: CancelorderComponent},
  {path: 'seller/order/:username/:auth/:role', component: SellerorderComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
