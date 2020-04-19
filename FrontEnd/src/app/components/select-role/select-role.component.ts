import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-select-role',
  templateUrl: './select-role.component.html',
  styleUrls: ['./select-role.component.scss']
})
export class SelectRoleComponent implements OnInit {

  @Input() username = 'no';
  @Input() auth = 'no';
  @Input() role = 'no';

  constructor(private route: ActivatedRoute, private router: Router) {
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.auth = params['auth'];
      this.role = params['role'];
    });
    this.checkRole();
   }

  ngOnInit(): void {
  }

  checkRole() {
    if (this.auth === 'yes'){
      this.router.navigate(['/userdetail/' + this.username + '/' + this.auth + '/' + this.role]);
    }
  }

}
