import { Item } from '../models/item';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import {REST_API} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private itemsUrl = 'api/items'

  constructor(private http: HttpClient) { }

  getItem(id: number): Observable<Item> {
    const url = `${REST_API}/detailitem/${id}`;
    return this.http.get<Item>(url)
  }

  getItems(): Observable<Item[]> {
    return this.http.get<Item[]>(REST_API + '/showitems')
  }

  addItem(item: Item) {
    return this.http.post(REST_API + '/newitem', item);
  }

  getUserItems(): Observable<Item[]> {
    return this.http.get<Item[]>(REST_API + '/useritems')
  }

}
