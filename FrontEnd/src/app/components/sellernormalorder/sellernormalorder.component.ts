import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartServiceService } from 'src/app/services/cart-service.service';

@Component({
  selector: 'app-sellernormalorder',
  templateUrl: './sellernormalorder.component.html',
  styleUrls: ['./sellernormalorder.component.scss']
})
export class SellernormalorderComponent implements OnInit {

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
    this.isloading = true;
    this.cartservice.getNormalOrder(this.username).subscribe(res => {
      this.isloading = false;
      this.results = res;
      console.log(this.results);
      if (Object.keys(res).length === 0){
        this.empty = true;
      }
    }, error => {
      this.isloading = false;
      this.error = error;
      console.log(error);
    });
  }

}
