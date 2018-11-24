import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { MatButtonModule,
  MatCardModule,
  MatInputModule,
  MatListModule,
  MatIconModule,
  MatMenuModule,
  MatProgressSpinnerModule,
  MatTableModule,
  MatToolbarModule,
  MatFormFieldModule,
  MatGridListModule,
  MatExpansionModule,
  MatDialogModule,
  MatSelectModule} from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';

import { AdubacaoListComponent } from './adubacao-list/adubacao-list.component';
import { AdubacaoAddComponent } from './adubacao-add/adubacao-add.component';
import { AdubacaoDetailComponent } from './adubacao-detail/adubacao-detail.component';
import { AdubacaoEditComponent } from './adubacao-edit/adubacao-edit.component';
import { AdubacaoDeleteDialogComponent } from './adubacao-list/adubacao-delete-dialog/adubacao-delete-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    AdubacaoListComponent,
    AdubacaoAddComponent,
    AdubacaoDetailComponent,
    AdubacaoEditComponent,
    AdubacaoDeleteDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatMenuModule,
    MatIconModule,
    MatTableModule,
    MatProgressSpinnerModule,
    MatGridListModule,
    MatExpansionModule,
    MatDialogModule,
    MatSelectModule,
  ],
  providers: [],
  entryComponents: [AdubacaoDeleteDialogComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
