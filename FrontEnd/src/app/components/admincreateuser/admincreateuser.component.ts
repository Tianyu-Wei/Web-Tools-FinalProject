import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admincreateuser',
  templateUrl: './admincreateuser.component.html',
  styleUrls: ['./admincreateuser.component.scss']
})
export class AdmincreateuserComponent implements OnInit {

  isloading = false;
  @Input() username;
  @Input() auth;
  @Input() role;
  error: string = '';
  

  constructor(private route: ActivatedRoute, private authService: AuthService) { }

  ngOnInit(): void {
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

      this.authService.signup(username, password, email, recovemail, phone, role).subscribe(resData => {
        console.log(resData);
        this.isloading = false;
      }, error => {
        console.log(error);

        this.error = 'An error happens!';
        this.isloading = false;
      });

    form.reset();
  }

}
