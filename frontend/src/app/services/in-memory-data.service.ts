import { Item } from '../models/item';
import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const items = [
    { id: 1, name: 'inzerát 1', price: 20, description: 'Predam tento model....' },
    { id: 2, name: 'inzerát 2', price: 10, description: 'Predam toto tu čo vidite...' },
    { id: 3, name: 'inzerát 3', price: 30, description: 'Predám tuto zachovalú...' },
    { id: 4, name: 'inzerát 4', price: 20, description: 'Predam tento model....'  },
    { id: 5, name: 'inzerát 5', price: 10, description: 'Predam toto tu čo vidite...' },
    { id: 6, name: 'inzerát 6', price: 30, description: 'Predám tuto zachovalú...' }
    ];
    return {items};
  }

  genId(items: Item[]): number {
    return items.length > 0 ? Math.max(...items.map(item => item.id)) + 1 : 11;
  }
}
