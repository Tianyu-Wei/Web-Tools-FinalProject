import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {SearchService} from '../../services/search.service';
import { AuthService } from 'src/app/services/auth.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

  keyword: string;
  category: string;
  result: number;
  @Input() username = 'no';
  @Input() auth = 'no';
  @Input() role = 'no';

  constructor(private route: ActivatedRoute, private searchService: SearchService, private authservice: AuthService, private cookie: CookieService,
    private router: Router) {
      this.route.params.subscribe(params => {
        this.username = params['username'];
        this.auth = params['auth'];
        this.role = params['role'];
      });
     }

  ngOnInit(): void {
    this.category = 'all';
  }

  logout(){
     this.authservice.logout();

     this.router.navigate(['/home/no/no/no']);
  }
}
