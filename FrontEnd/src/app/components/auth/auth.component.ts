import { Component, OnInit, Input } from '@angular/core';
import { NgForm, Form } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

  isLogin = true;
  isloading = false;
  error: string = null;
  @Input() auth = 'no';
  @Input() username = 'no';
  @Input() role = 'no';
  result: any;

  constructor(private authService: AuthService, private router: Router, private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.auth = params['auth'];
      this.role = params['role'];
    });
   }

  ngOnInit(): void {
  }

  SwitchLoginMode() {
    this.isLogin = !this.isLogin;
  }

  onSubmit(form: NgForm) {
    if (!form.valid) {
      return;
    }

    const email = form.value.email;
    const password = form.value.password;
    const username = form.value.username;
    const recovemail = form.value.recovemail;
    const phone = form.value.phone;
    const role = form.value.role;

    console.log(username);

    this.isloading = true;

    if (this.isLogin) {

    } else {
      this.authService.signup(username, password, email, recovemail, phone, role).subscribe(resData => {
        console.log(resData);
        this.isloading = false;
      }, error => {
        console.log(error);

        this.error = 'Successfully Signed up!';
        this.isloading = false;
      });
    }
    form.reset();
  }

  UserLogin(form: NgForm) {

    if (!form.valid) {
      return;
    }

    const username = form.value.username;
    const password = form.value.password;
    this.auth = 'yes';
    this.username = username;

    this.isloading = true;

    this.authService.login(username, password).subscribe(resData => {
      console.log(resData);
      this.isloading = false;
      this.result = resData;
      this.role = this.result.role;
      
      this.router.navigate(['/home/' + username + '/' + this.auth + '/' + this.role]);
        }, error => {
      console.log(error);
      this.error = 'Username not exists or Password error';
      this.isloading = false;
    });


  }

}
