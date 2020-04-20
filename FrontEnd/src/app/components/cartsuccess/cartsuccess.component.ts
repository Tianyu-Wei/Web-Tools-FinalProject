import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cartsuccess',
  templateUrl: './cartsuccess.component.html',
  styleUrls: ['./cartsuccess.component.scss']
})
export class CartsuccessComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() role;
  @Input() id;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(res => {
      this.username = res['username'];
      this.auth = res['auth'];
      this.role = res['role'];
      this.id = res['id'];
    });
   }

  ngOnInit(): void {
  }

}
