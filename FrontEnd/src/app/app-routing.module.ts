import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { SearchdetailComponent } from './components/searchdetail/searchdetail.component';
import { SearchresultsComponent } from './components/searchresults/searchresults.component';
import { AuthComponent } from './components/auth/auth.component';


const routes: Routes = [
  {path: '', component: MainComponent},
  {path: 'search/:category/:keyword', component: SearchresultsComponent},
  {path: 'detail/:id', component: SearchdetailComponent},
  {path: 'auth', component: AuthComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
