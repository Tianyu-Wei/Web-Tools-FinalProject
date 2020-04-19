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
    this.cartservice.getReturnOrder(this.username).subscribe(res => {
      this.results = res;
    }, error => {
      this.error = error;
      console.log(error);
    });
  }

  approve(ordernum: number){
    this.cartservice.approveReturn(ordernum.toString(), this.username).subscribe(res =>{
      this.router.navigate(['/seller/orders/return' + '/' + this.username + '/' + this.auth + '/' + this.role]);
    }, error => {
      this.error = error;
    });
  }

}
