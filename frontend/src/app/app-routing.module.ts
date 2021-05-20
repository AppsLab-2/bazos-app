import { FormspageComponent } from './components/formspage/formspage.component';
import { ContactComponent } from './components/contact/contact.component';
import { LoginComponent } from './components/login/login.component';
import { ItemDetailComponent } from './components/item-detail/item-detail.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemsComponent } from './components/items/items.component';
import { concat } from 'rxjs';
import {UserpageComponent} from "./components/userpage/userpage.component";
import {RegisterComponent} from "./components/register/register.component";
import {AuthGuard} from "./guard/auth.guard";


const routes: Routes = [
  { path: '', redirectTo: '/items', pathMatch: 'full' },
  { path: 'items', component: ItemsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'form', component: FormspageComponent, canActivate: [AuthGuard] },
  { path: 'detail/:id', component: ItemDetailComponent },
  { path: 'userpage', component: UserpageComponent },
  { path: 'register', component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
