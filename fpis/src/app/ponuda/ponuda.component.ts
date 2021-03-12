import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import {
  MatDialog,
  MatDialogConfig,
  MatDialogRef
} from '@angular/material/dialog';
import { ActivatedRoute, Params } from '@angular/router';
import { Observable, of as observableOf } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { PonudaModel } from 'src/app/models/ponudaModel';
import { DijalogIzmenaComponent } from '../dijalog-izmena/dijalog-izmena.component';
import { DijalogVerComponent } from '../dijalog-ver/dijalog-ver.component';
import { MetodeAPIService } from '../metode-api.service';
import { KupacModel } from '../models/kupacModel';
import { ProizvodModel } from '../models/proizvodModel';
import { StavkaModel } from '../models/stavkaModel';
import { TipModel } from '../models/tipModel';


@Component({
  selector: 'app-ponuda',
  templateUrl: './ponuda.component.html',
  styleUrls: ['./ponuda.component.css']
})
export class PonudaComponent implements OnInit {

  ponuda: PonudaModel = new PonudaModel({});
  ponude: PonudaModel[];
  stavka: StavkaModel = new StavkaModel({});
  listaStavki: any[];
  ponudaID: Observable<number>;
  selectedRow: number;
  isEdit: boolean;
  tipovi: Observable<TipModel[]>;
  tip: TipModel = new TipModel({});
  kupci: Observable<KupacModel[]>;
  kupac: KupacModel = new KupacModel({});
  proizvodi: ProizvodModel[];
  proizvod: ProizvodModel = new ProizvodModel({});
  ponudaForma: FormGroup;
  rb: number;


  selectRow(index) {
    this.selectedRow = index;
  }

  dateValidator(c: AbstractControl): { [key: string]: boolean } {
    let value = c.value;
    if (value && typeof value === "string") {
      let match = value.match(/^([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/);
      if (!match) {
        return { 'dateInvalid': true };
      } else if (match && match[0] !== value) {
        return { 'dateInvalid': true };
      }
    }
    return null;
  }
  constructor(
    private http: HttpClient,
    private metodeAPI: MetodeAPIService,
    private fb: FormBuilder,
    private dialog: MatDialog,
    public dialogIzmenaRef: MatDialogRef<DijalogIzmenaComponent>,
    public dialogRefVer: MatDialogRef<DijalogVerComponent>,
    public route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.ponudaForma = this.fb.group({
      brojPonude: [null],
      datum: [null],
      kupac: [null],
      zahtev: [null],
      tip: [null],
      listaStavki: this.fb.array(
        this.listaStavki ? this.listaStavki.map((stavka) => {
          return this.fb.group({
            proizvod: [null],
            kolicina: [null]
          });
        }) : []),
      proizvod: [null],
      kolicina: [null]
    });

    this.kupci = this.metodeAPI.vratiKupce();
    this.tipovi = this.metodeAPI.vratiTipove();
    this.metodeAPI.vratiProizvode().subscribe((proizvodi) => {
      this.proizvodi = proizvodi;
    });

    this.route.params.pipe(
      switchMap((params: Params) => {
        if (params.id) {
          return this.metodeAPI.vratiPonuduPoID(params.id);
        } else {
          const ponuda = {
            ponudaID: 0,
            datum: '',
            kupac: {},
            tip: {},
            zahtev: {},
            listaStavki: []
          } as PonudaModel;

          return observableOf(ponuda);
        }
      })).subscribe(ponuda => {
        this.ponuda = ponuda;
        this.listaStavki = ponuda.listaStavki;
        console.log(this.listaStavki)
        this.inicijalizacijaForme(ponuda);
      })
  }

  public inicijalizacijaForme(ponuda: PonudaModel) {
    console.log(this.ponuda)
    this.ponudaForma = this.fb.group({
      brojPonude: [this.ponuda.ponudaID, Validators.required],
      datum: [this.ponuda.datum, [Validators.required, this.dateValidator]],
      kupac: [this.ponuda.kupac.naziv, Validators.required],
      zahtev: [this.ponuda.zahtev.zahtevID, Validators.required],
      tip: [this.ponuda.tip.naziv, Validators.required],
      listaStavki: this.fb.array(
        this.listaStavki ? this.listaStavki.map((stavka) => {
          return this.fb.group({
            proizvod: [stavka.proizvod.naziv, Validators.required],
            kolicina: [stavka.kolicina, [Validators.required, Validators.pattern("[0-9]*$")]]
          });
        }) : []),
      proizvod: [null],
      kolicina: [null]
    });

  }

  selectedKupac = 'Stedjo elektro';
  selectedTip = 'gotovinski';

  novaPonuda() {
    this.metodeAPI.vratiIDPonude().subscribe((data) => {
      typeof (data);
      this.ponudaID = data;
      this.ponudaForma.patchValue({
        brojPonude: this.ponudaID
      }
      )
    });
  }

  dodajStavku() {
    let obj: any;
    this.proizvodi.forEach(element => {
      if (element.proizvodID === Number(this.ponudaForma.get('proizvod').value)) {
        obj = {
          rb: this.listaStavki.length + 1,
          proizvod: element,
          kolicina: this.ponudaForma.get('kolicina').value,
          jedinicaMere: element.jedinicaMere.oznaka
        }
      }
    });

    if (this.listaStavki.length > 0) {
      let postoji = false;
      this.listaStavki.forEach(element => {
        if (element.proizvod === obj.proizvod) {
          postoji = true;
        }
      });
      
      if (postoji) {
        alert('Proizvod je vec dodat!');
      } else {
        this.listaStavki.push(obj);
      }
    } else {
      this.listaStavki.push(obj);
    }

    this.ponudaForma.get('proizvod').setValue(null);
    this.ponudaForma.get('kolicina').setValue(null);
  }

  obrisiStavku(stavka) {
    this.listaStavki.forEach((value, index) => {
      if (value == stavka) {
        this.listaStavki.splice(index, 1);
      }
    });
  }

  izmeniStavku(stavka) {
    this.proizvodi.forEach(element => {
      if (element.naziv === stavka.proizvod) {
        this.ponudaForma.get('proizvod').setValue(element.proizvodID);
        return;
      }
    });
    this.ponudaForma.get('kolicina').setValue(stavka.kolicina);
    this.rb = stavka.rb;
  }

  potvrdiIzmenu() {
    let pr;
    this.proizvodi.forEach(element => {
      if (element.proizvodID === Number(this.ponudaForma.get('proizvod').value)) {
        pr = element;
        return;
      }
    });

    this.listaStavki.forEach(element => {
      if (element.rb === this.rb) {
        element.proizvod = pr.naziv;
        element.kolicina = this.ponudaForma.get('kolicina').value;
        this.rb = 0;
        this.ponudaForma.get('proizvod').setValue(null);
        this.ponudaForma.get('kolicina').setValue(null);
        return;
      }
    });
  }

  sacuvajPonudu() {
    this.onSubmitPonuda();
  }

  onSubmitPonuda() {
    const pomPonuda = this.ponudaForma.value;
    console.log(pomPonuda)
    this.ponuda.ponudaID = pomPonuda.brojPonude;
    this.ponuda.datum = pomPonuda.datum;
    this.ponuda.kupac = pomPonuda.kupac;
    this.ponuda.zahtev = pomPonuda.zahtev;
    this.ponuda.tip = pomPonuda.tip;
    this.ponuda.listaStavki = this.listaStavki;
    console.log(this.listaStavki)
    const obj = {
      ponudaID: this.ponuda.ponudaID,
      datum: this.ponuda.datum,
      kupac: this.ponuda.kupac,
      zahtev: this.ponuda.zahtev,
      tip: this.ponuda.tip,
      listaStavki: this.ponuda.listaStavki
    }
    console.log(this.ponuda.listaStavki)

    console.log(obj);
    this.metodeAPI.unesiPonudu(obj).subscribe(
      (data) => {
        console.log('Data:', data);
      },
      (error) => {
        console.log('Error:', error);
      }
    );

  }

  izmeniPonudu(){
    const pomPonuda = this.ponudaForma.value;
    console.log(pomPonuda)
    this.ponuda.ponudaID = pomPonuda.brojPonude;
    this.ponuda.datum = pomPonuda.datum;
    this.ponuda.kupac = pomPonuda.kupac;
    this.ponuda.zahtev = pomPonuda.zahtev;
    this.ponuda.tip = pomPonuda.tip;
    this.ponuda.listaStavki = this.listaStavki;
    
    const obj = {
      ponudaID: this.ponuda.ponudaID,
      datum: this.ponuda.datum,
      kupac: this.ponuda.kupac,
      zahtev: this.ponuda.zahtev,
      tip: this.ponuda.tip,
      listaStavki: this.ponuda.listaStavki
    }

    console.log(obj);
    this.metodeAPI.azurirajPonudu(obj).subscribe(
      (data) => {
        console.log('Data:', data);
      },
      (error) => {
        console.log('Error:', error);
      }
    );
  }

  onReset() {
    this.ponudaForma.reset();
  }
}
