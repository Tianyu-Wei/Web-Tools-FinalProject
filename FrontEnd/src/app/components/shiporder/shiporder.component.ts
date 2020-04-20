import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartServiceService } from 'src/app/services/cart-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-shiporder',
  templateUrl: './shiporder.component.html',
  styleUrls: ['./shiporder.component.scss']
})
export class ShiporderComponent implements OnInit {

  @Input() adminname;
  @Input() ordernum;
  @Input() username;
  @Input() auth;
  @Input() role;
  error = '';
  isloading = false;

  constructor(private route: ActivatedRoute, private cartservice: CartServiceService, private router: Router) {
    this.route.params.subscribe(res => {
      this.adminname = res['adminname'];
      this.ordernum = res['ordernum'];
      this.username = res['username'];
      this.auth = res['auth'];
      this.role = res['role'];
    })
   }

  ngOnInit(): void {
  }

  shiporder(form: NgForm){
    this.isloading = true;
const labelnum = form.value.labelnum;

    this.cartservice.shipOrder(this.username, this.ordernum, labelnum).subscribe(res => {
      this.isloading = false;
      this.router.navigate(['/shipsuccess/' + this.username + '/' + this.auth + '/' + this.role]);
    }, error => {
      this.isloading = false;
      this.error = error;
      this.router.navigate(['/shipsuccess/' + this.username + '/' + this.auth + '/' + this.role]);
    });
  }

}
