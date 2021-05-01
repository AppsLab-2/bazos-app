import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";
import {UserService} from "../../services/user.service";
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userForm = new FormGroup({
    firstName: new FormControl("", Validators.required),
    lastName: new FormControl("", Validators.required),
    email: new FormControl("", Validators.email),
    password: new FormControl("", Validators.required),
    address: new FormControl("", Validators.required),
    city: new FormControl("", Validators.required),
    state: new FormControl("", Validators.required),
    phoneNumber: new FormControl("", Validators.required),
  });

  get submit(): boolean {
    return this.userForm.valid;
  }

  constructor(private userService:UserService,
              private readonly router: Router) { }

  ngOnInit(): void {
  }

  onSubmit():void{

    this.userService.AddUser(this.userForm.value)
      .subscribe(() => this.router.navigateByUrl('/login'));
  }

}
