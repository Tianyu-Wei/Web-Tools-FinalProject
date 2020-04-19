import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartServiceService } from 'src/app/services/cart-service.service';
import { orderresult } from 'src/app/models/orderresult';

@Component({
  selector: 'app-ordermanage',
  templateUrl: './ordermanage.component.html',
  styleUrls: ['./ordermanage.component.scss']
})
export class OrdermanageComponent implements OnInit {

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
    this.cartservice.getOrder(this.username).subscribe(res => {
      this.results = res;
      console.log(this.results);
    }, error => {
      this.error = 'Get order failed!';
    });
  }

  getOrderList() {
    this.cartservice.getOrderlist(this.username).subscribe(res => {
      this.orderDetail = res;
      console.log(this.orderDetail);
    });
  }

  return(id: number) {
    this.cartservice.returnOrder(id.toString(), this.username).subscribe(res => {
    });
    this.router.navigate(['/ordersuccess/' + this.username + '/' + this.role + '/' + this.auth]);
  }

}
