import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { User } from '../model/user.model';

@Injectable()
export class UserService {
  api_users = "http://localhost:8080/api/users";  

  constructor(
    public http: Http
  ) { }

  getUsers() {
    return this.http.get(this.api_users);
  }

  saveUsers(user: User) {
    return this.http.post(this.api_users, user);
  }

  deleteUsers(userId: string) {
    return this.http.delete(`${this.api_users}/${userId}`);
  }

}
