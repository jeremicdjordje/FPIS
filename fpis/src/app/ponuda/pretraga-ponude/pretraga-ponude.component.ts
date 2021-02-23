import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { debounceTime, distinctUntilChanged, map, mergeMap } from 'rxjs/operators';
import { DijalogVerComponent } from 'src/app/dijalog-ver/dijalog-ver.component';
import { MetodeAPIService } from 'src/app/metode-api.service';
import { PonudaModel } from 'src/app/models/ponudaModel';
import { of as observableOf, Subject } from 'rxjs';

@Component({
  selector: 'app-pretraga-ponude',
  templateUrl: './pretraga-ponude.component.html',
  styleUrls: ['./pretraga-ponude.component.css']
})
export class PretragaPonudeComponent implements OnInit {
  ponude: PonudaModel[];
  kriterijum: string = '';
  private selectedRowIndex: number;
  private selectedRow;
  public keyUp = new Subject<string>();
  public listaPrikaz: any[];

  constructor(
    private http: HttpClient,
    private metodaAPI: MetodeAPIService,
    private fb: FormBuilder,
    private dialogRefVer: MatDialogRef<DijalogVerComponent>,
    private dialog: MatDialog,
    private router: Router
  ) {

  }

  formaPretrage = this.fb.group({
    'kriterijum': new FormControl(null)
  }
  );

  ngOnInit(): void {
    this.vratiPonude();

    this.keyUp.pipe(
      map((event: any) => event.target.value),
      debounceTime(300),
      distinctUntilChanged(),
      mergeMap(search => observableOf(search)))
      .subscribe(response => {
        console.log(response)
        if (response.length >= 1) {
          this.listaPrikaz = [];
          this.ponude.forEach(element => {
            if (element.ponudaID.toString().includes(response) ||
              element.datum.includes(response) ||
              element.kupac.naziv.includes(response) ||
              element.tip.naziv.includes(response) ||
              element.zahtev.zahtevID.toString().includes(response)) {
              this.listaPrikaz.push(element);
            }
          });
        }else{
          this.listaPrikaz = this.ponude;
        }
      });
  }

  vratiPonude() {
    this.metodaAPI.vratiPonude().subscribe((data) => {
      console.log(data);
      this.ponude = data;
      this.listaPrikaz = this.ponude;
    })
  }
  selectRow(index) {
    this.selectedRowIndex = index;
  }

  openDialogVer(index) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    this.dialogRefVer = this.dialog.open(
      DijalogVerComponent,
      dialogConfig
    );

    this.dialogRefVer.afterClosed().subscribe((value) => {
      if (value == 'da') {
        console.log('Vratilo se:', value);

        this.metodaAPI.obrisiPonudu(this.ponude[index].ponudaID).subscribe((data) => {
          console.log("Data", data);
        }, (error) => {
          console.log("Error:", error)
        });
        this.ponude.splice(index, 1);
      }
    });
  }

  public otvoriEdit(id: number) {
    this.router.navigateByUrl(`ponuda/${id}`)
  }
}