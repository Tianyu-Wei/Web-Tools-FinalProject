import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-deletesuccess',
  templateUrl: './deletesuccess.component.html',
  styleUrls: ['./deletesuccess.component.scss']
})
export class DeletesuccessComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() role;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(res => {
      this.username = res['username'];
      this.auth = res['auth'];
      this.role = res['role'];
    });
   }

  ngOnInit(): void {
  }

}
