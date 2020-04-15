import { Component, OnInit, Input } from '@angular/core';
import { CrudItemService } from 'src/app/services/crud-item.service';
import { SearchService } from 'src/app/services/search.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-seller-product',
  templateUrl: './seller-product.component.html',
  styleUrls: ['./seller-product.component.scss']
})
export class SellerProductComponent implements OnInit {

  @Input() username;
  @Input() auth;
  status: string = ''; 
  results: any;
  error = '';

  constructor(private crudItemservice: CrudItemService, private getItemservice: SearchService, private route: ActivatedRoute) {
    this.route.params.subscribe(res => {
      this.username = res['username'];
      this.auth = res['auth'];
    });
    this.getItem();
   }

  ngOnInit(): void {
  }

  deleteitem(id: string) {
    this.crudItemservice.deleteItemService(id).subscribe(res => {
      this.status = 'Delete successfully!';
    },
      error => {
        this.status = 'Delete Failed!';
    })
  }

  getItem() {
    this.getItemservice.getMainDataService().subscribe(res => {
      this.results = res;
    }, error => {
      console.log(error);
      this.error = error;
    });
  }

}
