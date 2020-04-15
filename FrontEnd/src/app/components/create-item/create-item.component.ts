import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CrudItemService } from 'src/app/services/crud-item.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-item',
  templateUrl: './create-item.component.html',
  styleUrls: ['./create-item.component.scss']
})
export class CreateItemComponent implements OnInit {

  @Input() username;
  @Input() auth;
  @Input() role;
  error = '';
  isCreating = false;

  constructor(private route: ActivatedRoute, private crudservice: CrudItemService, private router: Router) {
    this.route.params.subscribe(res => {
      this.username = res['username'];
      this.auth = res['auth'];
      this.role = res['role'];
    })
   }

  ngOnInit(): void {
  }

  createItem(form: NgForm){
    this.isCreating = true;
    const name = form.value.proname;
    const amount = form.value.amount;
    const price = form.value.price;
    const category = form.value.category;
    const description = form.value.description;
    const imgUrl = form.value.imgURL;
    const discount = form.value.discount;

    this.crudservice.createItemService(name, amount, price, category, description, imgUrl, discount).subscribe(res => {
      this.router.navigate(['/seller/manageproduct/' + this.username + '/' + this.auth + '/' + this.role]);
      this.isCreating = false;
    }, error => {
      this.error = error;
      this.isCreating = false;
    });
  }

}
