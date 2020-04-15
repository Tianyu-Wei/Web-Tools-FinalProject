import { Component, OnInit, Input } from '@angular/core';
import { SearchService } from 'src/app/services/search.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  @Input() username = 'no';
  @Input() auth = 'no';
  @Input() role = 'no';
  results: any;

  constructor(private getsearch: SearchService, private route: ActivatedRoute) {
    this.getMainData();

    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.auth = params['auth'];
      this.role = params['role'];
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