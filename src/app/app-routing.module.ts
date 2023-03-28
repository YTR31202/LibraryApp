import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';
import { ViewBookComponent } from './view-book/view-book.component';
import { BookdetailsComponent } from './bookdetails/bookdetails.component';

const routes: Routes = [
  { path:'',redirectTo:'books',pathMatch:'full'},
  {path:'add1', component: AddBookComponent},
  {path:'books',component: ViewBookComponent},
  {path:'books/:id',component: BookdetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
