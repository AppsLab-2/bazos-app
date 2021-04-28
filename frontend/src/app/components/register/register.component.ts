import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";
import {UserService} from "../../services/user.service";
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userForm = new FormGroup({
    fisrtName: new FormControl("", Validators.required),
    lastName: new FormControl("", Validators.required),
    email: new FormControl("", Validators.email),
    address: new FormControl("", Validators.required),
    city: new FormControl("", Validators.required),
    state: new FormControl("", Validators.required),
    phoneNumber: new FormControl("", Validators.required),
  });

  get submit(): boolean {
    return this.userForm.valid;
  }

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  onSubmit():void{
    const model = {
      firstName: this.userForm.controls.firstName.value,
      lastName: this.userForm.controls.lastName.value,
      email: this.userForm.controls.email.value,
      address: this.userForm.controls.address.value,
      city: this.userForm.controls.city.value,
      state: this.userForm.controls.state.value,
      phoneNumber: this.userForm.controls.phoneNumber.value,
    }
    this.userService.AddUser(model as User).subscribe();
  }

}
