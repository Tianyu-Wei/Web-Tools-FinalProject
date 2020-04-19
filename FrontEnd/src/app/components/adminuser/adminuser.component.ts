import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-adminuser',
  templateUrl: './adminuser.component.html',
  styleUrls: ['./adminuser.component.scss']
})
export class AdminuserComponent implements OnInit {

@Input() username;
@Input() auth;
@Input() role;
result: any;
error = '';

  constructor(private route: ActivatedRoute, private authservice: AuthService) {
    this.route.params.subscribe(res => {
      this.username = res['username'];
      this.auth = res['auth'];
      this.role = res['role'];
    });
    this.getUserList();
   }

  ngOnInit(): void {
  }

  getUserList(){
    this.authservice.getUserList().subscribe(res => {
      this.result = res;
      console.log(this.result);
    }, error => {
      this.error = error;
    });
  }

  delete(id: number){
    this.authservice.deleteUser(id.toString()).subscribe(res => {
    }, error => {
      this.error = error;
    });
  }
}
