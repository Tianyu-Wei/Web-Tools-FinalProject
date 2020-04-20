import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-returnsuccess',
  templateUrl: './returnsuccess.component.html',
  styleUrls: ['./returnsuccess.component.scss']
})
export class ReturnsuccessComponent implements OnInit {

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
