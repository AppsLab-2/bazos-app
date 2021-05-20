import { ItemService } from '../../services/item.service';
import { AppComponent } from '../../app.component';
import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Item } from '../../models/item'


@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {
  items: Item[] = [];
  sortBy: string = 'name';

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
  this.getItems();
  }

  getItems(): void{
    this.itemService.getItems()
      .subscribe(items => this.items = items);
  }

  sortItem(sortBy: string){
    this.sortBy = sortBy
    this.sort();
  }
  sort() {
    if(this.sortBy === 'name')
      this.items.sort((a,b) => a.name.localeCompare(b.name));

    if(this.sortBy === 'lowestPrice')
      this.items.sort((a,b) => a.price > b.price ? 1 : -1);

    if(this.sortBy === 'BiggestPrice')
      this.items.sort((a,b) => a.price > b.price ? 1 : -1);
  }
}
