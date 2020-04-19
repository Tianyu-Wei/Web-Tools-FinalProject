import { Component, OnInit, Input } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/models/User';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { timeout } from 'rxjs/operators';

@Component({
  selector: 'app-userdetail',
  templateUrl: './userdetail.component.html',
  styleUrls: ['./userdetail.component.scss']
})
export class UserdetailComponent implements OnInit {

  isLoaded = false;
  Update = false;
  oldusername: string;
  @Input() username = 'no';
  @Input() authen = 'no';
  @Input() role = 'no';
  result: User;
  updateresult: string;
  error: string = null;
  Updated = false;

  constructor(private cookie: CookieService, private auth: AuthService, private route: ActivatedRoute, private router: Router) { 

    this.route.params.subscribe(params => {
      this.oldusername = params['username'];
      this.authen = params['auth'];
      this.role = params['role'];
    });
    this.getUserDetail();
  }

  ngOnInit(): void {
  }

  getUserDetail(){
    this.isLoaded = false;

    if(this.authen === 'yes'){

    this.auth.getUser(this.oldusername).subscribe(res => {
      this.result = res;
      console.log(this.result);
      this.isLoaded = true;
    });
  } else{
    this.router.navigate(['/error/' + this.username + '/' + this.auth + '/' + this.role]);
  }
  }

  UpdateDetail(form: NgForm){
    this.isLoaded = false;
    const email = form.value.email;
    const password = form.value.password;
    const username = form.value.username;
    const recovemail = form.value.recovemail;
    const phone = form.value.phone;

    this.auth.updateUser(this.oldusername, username, password, email, recovemail, phone).subscribe(res => {
      this.Update = false;
      this.oldusername = username;
      this.getUserDetail();
      this.isLoaded = true;
      this.Updated = true;
    }, error => {
      console.log(error);
      this.error = "Something Wrong! Please check the information you submited.";
    });
    
  }

  onSwitchUpdate() {
    if(this.Update === false){
      this.Update = true;
    }else {
      this.Update = false;
    }
  }

}
