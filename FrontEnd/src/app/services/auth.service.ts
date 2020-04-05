import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface AuthResponseData {
  kind: string;
  idTokin: string;
  email: string;
  refreshToken: string;
  expiresIn: string;
  localId: string
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  signup(email: string, password: string) {
    return this.http.post<AuthResponseData>("http://localhost:8080/BackEnd_war_exploded/api/auth", 
    {
      email: email,
      password: password
    }
    );
  }
}
