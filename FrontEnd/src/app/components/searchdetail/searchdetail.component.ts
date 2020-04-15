import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { searchresult } from 'src/app/models/searchresult';
import { FetchdataService } from 'src/app/services/fetchdata.service';

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

  constructor(private fetchdataService: FetchdataService, private route: ActivatedRoute) {
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

}
