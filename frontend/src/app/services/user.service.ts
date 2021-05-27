import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from "../models/user";
import {REST_API} from "../../environments/environment";
import {Observable} from "rxjs";
import {Item} from "../models/item";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

    addUser(user: User) {
      return this.http.post(REST_API + '/saveuser', user);
  }

  getUserInfo(email: string): Observable<Item> {
    const url = `${REST_API}/detailuser/{email}`;
    return this.http.get<Item>(url)
  }
}
