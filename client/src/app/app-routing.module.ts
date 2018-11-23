import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { AdubacaoListComponent } from './adubacao-list/adubacao-list.component';
import { AdubacaoAddComponent } from './adubacao-add/adubacao-add.component';
import { AdubacaoDetailComponent } from './adubacao-detail/adubacao-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/adubacao-list', pathMatch: 'full' },
  {
    path: 'adubacao-list',
    component: AdubacaoListComponent
  },
  {
    path: 'adubacao-add',
    component: AdubacaoAddComponent
  },
  {
    path: 'adubacao-edit/:id',
    component: AdubacaoAddComponent
  }
  {
    path: 'adubacao-detail/:id',
    component: AdubacaoDetailComponent
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
