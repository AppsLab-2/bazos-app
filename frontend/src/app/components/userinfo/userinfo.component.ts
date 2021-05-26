import { ItemService } from '../../services/item.service';
import { Item } from '../../models/item';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common'
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";

@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {

  item?: Item;
  user?: User;


  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private itemService: ItemService,
    private userService: UserService) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.itemService.getItem(id)
      .subscribe(item => {
        this.item = item; this.user = item.users;
      });
  }

  goBack(): void {
    this.location.back();
  }
}
