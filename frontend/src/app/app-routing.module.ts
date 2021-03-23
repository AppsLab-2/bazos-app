import { FormspageComponent } from './formspage/formspage.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { ItemDetailComponent } from './item-detail/item-detail.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemsComponent } from './items/items.component';
import { concat } from 'rxjs';


const routes: Routes = [
  { path: '', redirectTo: '/items', pathMatch: 'full' },
  { path: 'items', component: ItemsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'form', component: FormspageComponent },
  { path: 'detail/:id', component: ItemDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }