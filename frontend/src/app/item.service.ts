import { ITEMS } from './mock-items';
import { Item } from './items/item';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor() { }

  getItems(): Observable<Item[]> {
    const items = of(ITEMS);
    return items;
  }
}
