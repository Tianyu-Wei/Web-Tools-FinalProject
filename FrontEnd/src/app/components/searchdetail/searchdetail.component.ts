import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { searchresult } from 'src/app/models/searchresult';
import { FetchdataService } from 'src/app/services/fetchdata.service';
import { CartServiceService } from 'src/app/services/cart-service.service';

@Component({
  selector: 'app-searchdetail',
  templateUrl: './searchdetail.component.html',
  styleUrls: ['./searchdetail.component.scss']
})
export class SearchdetailComponent implements OnInit {

  id = '';
  results: searchresult;
  tmpresult: any;
  isLoading = false;
  @Input() username = 'no';
  @Input() auth = 'no';
  @Input() role = 'no';

  constructor(private fetchdataService: FetchdataService, private route: ActivatedRoute, private orderservice: CartServiceService, private router: Router) {
    route.params.subscribe(params => {
      this.id = params.id;
      this.auth = params['auth'];
      this.username = params['username'];
      this.role = params['role'];
    });
    this.getItemDetail();
  }

  ngOnInit(): void {
  }

  getItemDetail(): void {
    this.isLoading = true;
    this.tmpresult = this.fetchdataService.getItemDetailService(this.id);
    this.tmpresult.subscribe(res => {
      this.results = res;
      console.log(res);
      this.isLoading = false;
    });

  };

  addToCart(id: number){
    if (this.auth === 'no'){
      this.router.navigate(['/select/' + this.username + '/' + this.auth + '/' + this.role]);
    }else {
    const itemid = id.toString();

    this.orderservice.addToCart(this.username, itemid, '1').subscribe(res => {
      this.router.navigate(['/cartsuccess/' + this.id + '/' + this.username + '/' + this.auth + '/' + this.role]);
    });
    this.router.navigate(['/cartsuccess/' + this.id + '/' + this.username + '/' + this.auth + '/' + this.role]);
  }
  }

  createOrder(id: number){
    if (this.auth === 'no'){
      this.router.navigate(['/select/' + this.username + '/' + this.auth + '/' + this.role]);
    }else {
    const itemid = id.toString();

    this.orderservice.createOrder(this.username, itemid, '1').subscribe(res => {
      this.router.navigate(['/ordersuccess/' + this.username + '/' + this.auth + '/' + this.role]);
    });
    this.router.navigate(['/ordersuccess/' + this.username + '/' + this.auth + '/' + this.role]);
  }
  }

}
