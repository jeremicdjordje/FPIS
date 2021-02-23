import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-dijalog-ver',
  templateUrl: './dijalog-ver.component.html',
  styleUrls: ['./dijalog-ver.component.css']
})
export class DijalogVerComponent implements OnInit {
  odgovor: string = "ne";
  
  constructor(
    public dialogRef: MatDialogRef<DijalogVerComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit(): void {
  }
  
  obrisi() {
    this.odgovor = "da";
    this.dialogRef.close(this.odgovor);
  }
  neBrisi() {
    this.odgovor = "ne";
    this.dialogRef.close(this.odgovor);
  }
}