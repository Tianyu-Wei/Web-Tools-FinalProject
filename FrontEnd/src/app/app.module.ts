import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexComponent } from './components/index/index.component';
import { CartComponent } from './components/cart/cart.component';
import { MainComponent } from './components/main/main.component';
import { SearchdetailComponent } from './components/searchdetail/searchdetail.component';
import { SearchresultsComponent } from './components/searchresults/searchresults.component';
import { AuthComponent } from './components/auth/auth.component';
import { LoadingSpinnerComponent } from './components/share/loading-spinner/loading-spinner.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './services/auth.interceptor';
import { CookieService } from 'ngx-cookie-service';
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
import { OrdersuccessComponent } from './components/ordersuccess/ordersuccess.component';
import { CartsuccessComponent } from './components/cartsuccess/cartsuccess.component';
import { OrdermanageComponent } from './components/ordermanage/ordermanage.component';
import { AdminpanelComponent } from './components/adminpanel/adminpanel.component';
import { AdminuserComponent } from './components/adminuser/adminuser.component';
import { AdmincreateuserComponent } from './components/admincreateuser/admincreateuser.component';
import { SellerorderComponent } from './components/sellerorder/sellerorder.component';
import { SellernormalorderComponent } from './components/sellernormalorder/sellernormalorder.component';
import { SellerreturnComponent } from './components/sellerreturn/sellerreturn.component';
import { ShiporderComponent } from './components/shiporder/shiporder.component';
import { CancelorderComponent } from './components/cancelorder/cancelorder.component';
import { ReturnsuccessComponent } from './components/returnsuccess/returnsuccess.component';
import { DeletesuccessComponent } from './components/deletesuccess/deletesuccess.component';
import { ShipsuccessComponent } from './components/shipsuccess/shipsuccess.component';
import { UserdeletesuccessComponent } from './components/userdeletesuccess/userdeletesuccess.component';
import { ReturnproveComponent } from './components/returnprove/returnprove.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    CartComponent,
    MainComponent,
    SearchdetailComponent,
    SearchresultsComponent,
    AuthComponent,
    LoadingSpinnerComponent,
    UserdetailComponent,
    ErrorComponent,
    HomeComponent,
    CategoryComponent,
    CategoryDetailComponent,
    SellerPanelComponent,
    SelectRoleComponent,
    SellerProductComponent,
    UpdateItemComponent,
    CreateItemComponent,
    OrdersuccessComponent,
    CartsuccessComponent,
    OrdermanageComponent,
    AdminpanelComponent,
    AdminuserComponent,
    AdmincreateuserComponent,
    SellerorderComponent,
    SellernormalorderComponent,
    SellerreturnComponent,
    ShiporderComponent,
    CancelorderComponent,
    ReturnsuccessComponent,
    DeletesuccessComponent,
    ShipsuccessComponent,
    UserdeletesuccessComponent,
    ReturnproveComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    HttpClientModule,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    },
    CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
