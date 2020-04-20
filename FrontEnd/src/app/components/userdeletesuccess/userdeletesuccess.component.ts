import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-userdeletesuccess',
  templateUrl: './userdeletesuccess.component.html',
  styleUrls: ['./userdeletesuccess.component.scss']
})
export class UserdeletesuccessComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() role;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.auth = params['auth'];
      this.role = params['role'];
    });
   }

  ngOnInit(): void {
  }

}
