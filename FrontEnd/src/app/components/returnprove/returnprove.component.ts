import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-returnprove',
  templateUrl: './returnprove.component.html',
  styleUrls: ['./returnprove.component.scss']
})
export class ReturnproveComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() role;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(res => {
      this.username = res['username'];
      this.auth = res['auth'];
      this.role = res['role'];
    })
   }

  ngOnInit(): void {
  }

}
