import { Component, OnInit, Input } from '@angular/core';
import { searchresult } from 'src/app/models/searchresult';
import { ActivatedRoute } from '@angular/router';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.scss']
})
export class CategoryDetailComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() category;
  @Input() role;
  results: any;

  constructor(private route: ActivatedRoute, private searchservice: SearchService) { 
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.auth = params['auth'];
      this.category = params['cate'];
      this.role = params['role'];
    });
    this.getcategoryDetail();
}  

ngOnInit(): void {
}

getcategoryDetail() {
  this.searchservice.getCategoryService(this.category).subscribe(resData => {
    this.results = resData;
  });
}


}

