import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartServiceService } from 'src/app/services/cart-service.service';
import { order } from 'src/app/models/order';
import { timingSafeEqual } from 'crypto';

@Component({
  selector: 'app-sellerreturn',
  templateUrl: './sellerreturn.component.html',
  styleUrls: ['./sellerreturn.component.scss']
})
export class SellerreturnComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() role;
  results: any;
  orderDetail: any;
  error = '';
  status = '';
  isloading = false;
  empty = false;

  constructor(private route: ActivatedRoute, private cartservice: CartServiceService, private router: Router) {
    this.route.params.subscribe(res => {
      this.username = res['username'];
      this.auth = res['auth'];
      this.role = res['role'];
    });
    this.checkAuth();
    this.getOrder();
   }

  ngOnInit(): void {
  }

  checkAuth(){
    if (this.auth === 'no'){
      this.router.navigate(['/select/no/no/no']);
    }
  }

  getOrder(){
    this.isloading = true
    this.cartservice.getReturnOrder(this.username).subscribe(res => {
      this.results = res;
      this.isloading = false;
      if (Object.keys(res).length === 0){
        this.empty = true;
      }
    }, error => {
      this.error = error;
      console.log(error);
      this.isloading = false;
    });
  }

  approve(ordernum: number){
    this.isloading = true;
    this.cartservice.approveReturn(ordernum.toString(), this.username).subscribe(res =>{
      this.isloading = false;
      this.router.navigate(['/seller/orders/return/approve/' + this.username + '/' + this.auth + '/' + this.role]);
    }, error => {
      this.isloading = false;
      this.error = error;
    });
  }

}
