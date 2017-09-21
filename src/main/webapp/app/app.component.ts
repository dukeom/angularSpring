import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { User } from './model/user.model';
import { UserService } from './service/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'app';
  users: User[];
  user: User = new User();
  showForm: boolean = false;
  constructor(
    private userService: UserService
  ) {}

  ngOnInit() {
    this.loadAllUsers();
  }

  loadAllUsers() {
    this.userService.getUsers()
      .subscribe (res=> {
        this.users = res.json();
      })
  }

  addForm() {
    this.showForm = true;
  }

  cancel() {
    this.showForm = false;
  }

  save() {
    this.userService.saveUsers(this.user)
      .subscribe(
        (res) => this.loadAllUsers(),
        (res) => console.log(res)
      );    
  }

  delete(userId: string) {
    console.log(userId);
    if (confirm ('삭제하시겠습니까?')) {
      this.userService.deleteUsers(userId)
        .subscribe(
          (res) => this.loadAllUsers(),
          (res) => console.log(res)
        );
    }
  }
}
