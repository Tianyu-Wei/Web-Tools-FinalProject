import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-seller-panel',
  templateUrl: './seller-panel.component.html',
  styleUrls: ['./seller-panel.component.scss']
})
export class SellerPanelComponent implements OnInit {

  @Input() username = 'no';
  @Input() auth = 'no';
  @Input() role = 'no';

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
