import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartServiceService } from 'src/app/services/cart-service.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() role;
  results: any;
  error = '';
  isloading = false;

  constructor(private route: ActivatedRoute, private cartservice: CartServiceService, private router: Router) {
    this.route.params.subscribe(res => {
      this.username = res['username'];
      this.auth = res['auth'];
      this.role = res['role'];
    });
    this.checkAuth();
    this.getCart();
   }

  ngOnInit(): void {
  }

  checkAuth(){
    if (this.auth === 'no'){
      this.router.navigate(['/select/no/no/no']);
    }
  }

  getCart(){
    this.cartservice.getCartData(this.username).subscribe(res => {
      this.results = res;
    }, error => {
      this.error = 'Loading error! Please wait and try again.';
    });
  }

  createOrder(id: string){
    this.isloading = true;
      this.cartservice.createOrder(this.username, id, '1').subscribe(res => {
        this.router.navigate(['/ordersuccess/' + this.username + '/' + this.auth + '/' + this.role]);
        this.isloading = false;
      }, error => {
        this.router.navigate(['/ordersuccess/' + this.username + '/' + this.auth + '/' + this.role]);
        this.isloading = false;
      });
      
  }

  deleteOrder(id: string) {
    this.isloading = true;
    this.cartservice.deleteCartData(this.username, id).subscribe(res => {
      this.router.navigate(['/deletesuccess/' + this.username + '/' + this.auth + '/' + this.role]);
      this.isloading = false;
    }, error => {
      this.error = 'Delete failed!';
      this.router.navigate(['/deletesuccess/' + this.username + '/' + this.auth + '/' + this.role]);
      this.isloading = false;
    });
    
  }

}
