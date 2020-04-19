import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { Subject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { User } from '../models/User';
import { Config } from 'protractor';
import { CookieService } from 'ngx-cookie-service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user = new Subject<User>();

  constructor(private http: HttpClient) { }

  signup(username: string, password: string, email: string, recovemail: string, phone: string, role: string) {

    const userparams = new HttpParams()
    .set('username',username)
    .set('password', password)
    .set('email', email)
    .set('recovemail', recovemail)
    .set('phone', phone)
    .set('role', role)

    console.log(userparams);

    return this.http.post("http://localhost:8080/BackEnd_war_exploded/signup", userparams);
  }

  login(username: string, password: string): Observable<Array<User>>{

    const params = new HttpParams()
    .set('username', username)
    .set('password', password);

    return this.http.post<Array<User>>("http://localhost:8080/BackEnd_war_exploded/login", params);
  }

  getUserList(){
    const params = new HttpParams();
    return this.http.post<Array<User>>("http://localhost:8080/BackEnd_war_exploded/getuserlist", params);
  }

  getUser(username: string) {

    const params = new HttpParams()
    .set('username', username);
    console.log(username);

    return this.http.get<User>("http://localhost:8080/BackEnd_war_exploded/getuser", {params: params});
  }

  logout(){
    const params = new HttpParams();
    return this.http.post("http://localhost:8080/BackEnd_war_exploded/logout", params);
  }

  updateUser(oldusername: string, username: string, password: string, email: string, recovemail: string, phone: string){
    const params = new HttpParams()
    .set('oldusername', oldusername)
    .set('username',username)
    .set('password', password)
    .set('email', email)
    .set('recovemail', recovemail)
    .set('phone', phone);

    return this.http.post("http://localhost:8080/BackEnd_war_exploded/updateuser", params);
  }

  deleteUser(id: string){
    const params = new HttpParams()
    .set('id', id);

    return this.http.post("http://localhost:8080/BackEnd_war_exploded/deleteuser", params);
  }
}
