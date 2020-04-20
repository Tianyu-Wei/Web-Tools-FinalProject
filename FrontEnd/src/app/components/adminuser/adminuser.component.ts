import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
isloading = false;

  constructor(private route: ActivatedRoute, private authservice: AuthService, private router: Router) {
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
    this.isloading = true;
    this.authservice.getUserList().subscribe(res => {
      this.result = res;
      this.isloading = false;
      console.log(this.result);
    }, error => {
      this.isloading = false;
      this.error = error;
    });
  }

  delete(id: number){
    this.isloading = true;
    this.authservice.deleteUser(id.toString()).subscribe(res => {
      this.isloading = false;
      this.router.navigate(['/userdeletesuccess/' + this.username + '/' + this.auth + '/' + this.role]);
    }, error => {
      this.isloading = false;
      this.error = error;
      this.router.navigate(['/userdeletesuccess/' + this.username + '/' + this.auth + '/' + this.role]);
    });
  }

  update(oldusername: string) {
    this.router.navigate(['/adminuserupdate/' + oldusername + '/' + this.username + '/' + this.auth + '/' + this.role]);
  }
}
