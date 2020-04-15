import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CrudItemService } from 'src/app/services/crud-item.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.scss']
})
export class UpdateItemComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() role;
  @Input() id;
  isUpdating: boolean = false;

  constructor(private route: ActivatedRoute, private crudservice: CrudItemService, private router: Router) {
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.auth = params['auth'];
      this.role = params['role'];
      this.id = params['id'];
    });

   }

  ngOnInit(): void {
  }

update(form: NgForm) {
  const name = form.value.proname;
  const amount = form.value.amount;
  const price = form.value.price;
  const category = form.value.category;
  const description = form.value.description;
  const imgUrl = form.value.imgURL;
  const discount = form.value.discount;

  this.crudservice.updateItemService(this.id, name, amount, price, category, description, imgUrl, discount).subscribe(res => {
    this.router.navigate(['/seller/manageproduct/' + this.username + '/' + this.auth + '/' + this.role]);
  }, error => {
    this.router.navigate(['/seller/manageproduct/' + this.username + '/' + this.auth + '/' + this.role]);
  });
}

}
