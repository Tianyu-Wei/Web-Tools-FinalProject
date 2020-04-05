import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

  isLogin = true;

  constructor(private authService: AuthService) { }

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

    if (this.isLogin) {

    } else {
      this.authService.signup(email, password).subscribe(resData => {
        console.log(resData);
      }, error => {
        console.log(error);
      });
    }
    
    form.reset();
  }

}
