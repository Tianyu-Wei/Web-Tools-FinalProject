import { Component, OnInit } from '@angular/core';
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

  constructor(private fetchdataService: FetchdataService, private route: ActivatedRoute) {
    route.params.subscribe(params => {
      this.id = params.id;
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
