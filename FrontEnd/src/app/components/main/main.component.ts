import { Component, OnInit, Input } from '@angular/core';
import { SearchService } from 'src/app/services/search.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  @Input() username = 'no';
  @Input() auth = 'no';
  results: any;

  constructor(private getsearch: SearchService, private route: ActivatedRoute) {
    this.getMainData();

    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.auth = params['auth'];
    });
  }

  ngOnInit(): void {
  }

  getMainData(): void {
    const searchresult = this.getsearch.getMainDataService();

    searchresult.subscribe(item => {
      this.results = item;
    });
  }
}
