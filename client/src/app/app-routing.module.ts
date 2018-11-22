import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { LaudoListComponent } from './laudo-list/laudo-list.component';
import { LaudoEditComponent } from './laudo-edit/laudo-edit.component';

const routes: Routes = [
  { path: '', redirectTo: '/laudo-list', pathMatch: 'full' },
  {
    path: 'laudo-list',
    component: LaudoListComponent
  },
  {
    path: 'laudo-add',
    component: LaudoEditComponent
  },
  {
    path: 'laudo-edit/:id',
    component: LaudoEditComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule { }
