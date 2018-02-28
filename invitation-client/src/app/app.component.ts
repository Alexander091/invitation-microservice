import {Component} from '@angular/core';
import {MatDialog, MatSnackBar} from "@angular/material";
import {NewDateFormComponent} from "./new-date-form/new-date-form.component";
import {SubmitService} from "./service/submit.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  dateMeeting = new Date(2018, 1, 28);
  email:string;
  name = 'Тань';
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  constructor(public dialog: MatDialog
    , private submitService: SubmitService
    , private spinnerService: Ng4LoadingSpinnerService
    , public snackBar: MatSnackBar) {
  }

  openDialog(): void {
    let dialogRef = this.dialog.open(NewDateFormComponent, {
      width: '300px',
      data: {name: this.name, dateMeeting: this.dateMeeting}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      if (result) {
        this.dateMeeting = result;
      }
    });

  }

  submitForm(): void {
    this.spinnerService.show();
    this.submitService.submit(this.dateMeeting, this.email).subscribe(
      res => {
        this.spinnerService.hide();
        this.openSnackBar("Фух, всё отправилось!", 600);
        console.log(res);
      },
      err => {
        this.spinnerService.hide();
        this.openSnackBar("Ай, ошибочка! Лучше позвони мне... мне будет приятно:)", 2200);
        console.log("Error occured");
      }
    );
  }

  openSnackBar(message: string, duration: number) {
    this.snackBar.open(message, "", {
      duration: duration,
    });
  }
}




