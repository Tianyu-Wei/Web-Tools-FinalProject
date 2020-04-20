import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-shipsuccess',
  templateUrl: './shipsuccess.component.html',
  styleUrls: ['./shipsuccess.component.scss']
})
export class ShipsuccessComponent implements OnInit {

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
