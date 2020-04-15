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


const routes: Routes = [
  {path: '', redirectTo: '/home/no/no/no', pathMatch: 'full'},
  {path: 'home/:username/:auth/:role', component: HomeComponent},
  {path: 'search/:category/:keyword/:username/:auth/:role', component: SearchresultsComponent},
  {path: 'detail/:id/:username/:auth/:role', component: SearchdetailComponent},
  {path: 'select/:username/:auth/:role', component: SelectRoleComponent},
  {path: 'auth/:username/:auth/:role', component: AuthComponent},
  {path: 'userdetail/:username/:auth/:role', component: UserdetailComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'category/:username/:auth/:role', component: CategoryComponent},
  {path: 'categorydetail/:cate/:username/:auth/:role', component: CategoryDetailComponent},
  {path: 'seller/:username/:auth/:role', component: SellerPanelComponent},
  {path: 'seller/manageproduct/:username/:auth/:role', component: SellerProductComponent},
  {path: 'updateitem/:id/:username/:auth/:role', component: UpdateItemComponent},
  {path: 'createitem/:username/:auth/:role', component: CreateItemComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
