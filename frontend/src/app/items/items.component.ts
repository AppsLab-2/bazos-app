import { ItemService } from './../item.service';
import { AppComponent } from './../app.component';
import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Item } from './item'


@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {
  title = 'trade.co';
  items: Item[] = [];

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
  this.getItems();
  }

  getItems(): void{
    this.itemService.getItems()
      .subscribe(items => this.items = items);
  }
}