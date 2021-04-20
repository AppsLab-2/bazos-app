import { Item } from '../models/item';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private itemsUrl = 'api/items'

  constructor(private http: HttpClient) { }

  getItem(id: number): Observable<Item> {
    const url = `http://localhost:8080/detailitem/${id}`;
    return this.http.get<Item>(url)
  }

  getItems(): Observable<Item[]> {
    return this.http.get<Item[]>('http://localhost:8080/showitems')
  }
}