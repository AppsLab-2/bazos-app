import { Component, OnInit } from '@angular/core';
import { Item } from "../../models/item";
import {UserService} from "../../services/user.service";
import {ItemService} from "../../services/item.service";
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {User} from "../../models/user";


@Component({
  selector: 'app-formspage',
  templateUrl: './formspage.component.html',
  styleUrls: ['./formspage.component.css']
})
export class FormspageComponent implements OnInit {

  itemForm = new FormGroup({
    name: new FormControl("", Validators.required),
    price: new FormControl("", Validators.required),
    description: new FormControl("", Validators.required),
  });

  get submit(): boolean {
    return this.itemForm.valid;
  }

  constructor(private itemService:ItemService) { }

  ngOnInit(): void {
  }

  AddItem():void{
    const model = {
      name: this.itemForm.controls.name.value,
      price: this.itemForm.controls.price.value,
      description: this.itemForm.controls.description.value,
    }
    this.itemService.AddItem(model as Item).subscribe();
  }
}
