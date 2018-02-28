import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';


import { AppComponent } from './app.component';
import {
  MatButtonModule, MatDatepickerModule, MatDialogModule, MatInputModule,
  MatNativeDateModule, MatSnackBarModule
} from "@angular/material";
import { NewDateFormComponent } from './new-date-form/new-date-form.component';
import {FormControl, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SubmitService} from "./service/submit.service";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";


@NgModule({
  declarations: [
    AppComponent,
    NewDateFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatDatepickerModule,
    MatDialogModule,
    MatInputModule,
    FormsModule,
    MatNativeDateModule,
    HttpClientModule,
    MatSnackBarModule,
    ReactiveFormsModule,
    Ng4LoadingSpinnerModule.forRoot()
  ],
  providers: [SubmitService],
  bootstrap: [AppComponent],
  entryComponents: [NewDateFormComponent]
})
export class AppModule { }
