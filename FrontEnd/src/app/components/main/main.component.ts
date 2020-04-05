import { Component, OnInit } from '@angular/core';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

  results: any;

  constructor(private getsearch: SearchService) {
    this.getMainData();
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
