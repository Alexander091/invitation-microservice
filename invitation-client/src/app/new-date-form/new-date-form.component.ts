import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-new-date-form',
  templateUrl: './new-date-form.component.html',
  styleUrls: ['./new-date-form.component.css']
})
export class NewDateFormComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<NewDateFormComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
