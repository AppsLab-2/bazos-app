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

  user?: User;


  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private userService: UserService) { }

  ngOnInit(): void {
    this.getUserInfo();
  }

  goBack(): void {
    this.location.back();
  }

  getUserInfo(): void{
    this.userService.getUserInfo()
      .subscribe(users => this.user = users);
  }

}
