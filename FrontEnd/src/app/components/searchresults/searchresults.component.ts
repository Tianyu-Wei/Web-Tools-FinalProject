import { Component, OnInit, Input } from '@angular/core';
import { SearchService } from 'src/app/services/search.service';
import { ActivatedRoute } from '@angular/router';
import { searchresult } from 'src/app/models/searchresult';

@Component({
  selector: 'app-searchresults',
  templateUrl: './searchresults.component.html',
  styleUrls: ['./searchresults.component.scss']
})
export class SearchresultsComponent implements OnInit {

  category: string;
  keyword: string;
  tmpresult: any;
  result: searchresult;
  @Input() username = 'no';
  @Input() auth = 'no';
  @Input() role = 'no';

  constructor(private searchService: SearchService, private route: ActivatedRoute) { 
    this.route.params.subscribe(params => {
      this.category = params['category'];
      this.keyword = params['keyword'];
      this.username = params['username'];
      this.auth = params['auth'];
      this.role = params['role'];
    });
    this.getSearchResult();
  }

  ngOnInit(): void {
  }

  getSearchResult(): void {
    this.tmpresult = this.searchService.getDataService(this.category, this.keyword);
    this.tmpresult.subscribe(item => {
      this.result = item;
    });
  };

}
