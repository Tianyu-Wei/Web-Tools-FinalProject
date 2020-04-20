import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartServiceService } from 'src/app/services/cart-service.service';
import { timingSafeEqual } from 'crypto';

@Component({
  selector: 'app-cancelorder',
  templateUrl: './cancelorder.component.html',
  styleUrls: ['./cancelorder.component.scss']
})
export class CancelorderComponent implements OnInit {

  @Input() adminname;
  @Input() ordernum;
  @Input() username;
  @Input() auth;
  @Input() role;
  error = '';
  isloading = false;

  constructor(private route: ActivatedRoute, private cartservice: CartServiceService, private router: Router) {
    this.route.params.subscribe(res => {
      this.adminname = res['adminname'];
      this.ordernum = res['ordernum'];
      this.username = res['username'];
      this.auth = res['auth'];
      this.role = res['role'];
    })
   }

  ngOnInit(): void {
  }

  cancelorder(){
    this.isloading = true;
    this.cartservice.cancelOrder(this.ordernum, this.username).subscribe(res => {
      this.isloading = false;
      this.router.navigate(['/seller/orders/' + this.username + '/' + this.auth + '/' + this.role]);
    }, error => {
      this.isloading = false;
      this.error = error;
      console.log(this.error);
      this.router.navigate(['/seller/orders/' + this.username + '/' + this.auth + '/' + this.role]);
    });
  }

}
