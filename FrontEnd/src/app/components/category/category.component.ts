import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SearchService } from 'src/app/services/search.service';
import { searchresult } from 'src/app/models/searchresult';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() role;

  constructor(private route: ActivatedRoute, private searchservice: SearchService) { 
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.auth = params['auth'];
      this.role = params['role'];
    })

  }

  ngOnInit(): void {
  }
}
