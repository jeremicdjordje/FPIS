import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dijalog-izmena',
  templateUrl: './dijalog-izmena.component.html',
  styleUrls: ['./dijalog-izmena.component.css'],
})
export class DijalogIzmenaComponent implements OnInit {
  ponuda;

  constructor(
    public dialogRef: MatDialogRef<DijalogIzmenaComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.ponuda = data;
    console.log('Doslo:', this.ponuda);
  }

  ngOnInit(): void {
  }
  


}
