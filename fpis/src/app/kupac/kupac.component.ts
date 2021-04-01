import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder, } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { KupacModel } from 'src/app/models/kupacModel';
import { MetodeAPIService } from 'src/app/metode-api.service';
import { MestoModel } from '../models/mestoModel';
import { UlicaModel } from '../models/ulicaModel';
import { Observable } from 'rxjs';
import { formatCurrency } from '@angular/common';


@Component({
  selector: 'app-kupac',
  templateUrl: './kupac.component.html',
  styleUrls: ['./kupac.component.css']
})
export class KupacComponent implements OnInit {

  kupci: KupacModel[];
  kupac: KupacModel;
  selectedRow: number;
  isEdit: boolean;
  pib: number;
  mesta: Observable<MestoModel[]>;
  mesto: MestoModel = new MestoModel({});
  ulice: Observable<UlicaModel[]>;
  ulica: UlicaModel = new UlicaModel({});

  constructor(
    private metodeAPI: MetodeAPIService,
    //private dialog: MatDialo,
    //public dialogRef: MatDialogRef<DialogRacunComponent>,
    //public dialogRefVer: MatDialogRef<DialogVerifikacijaComponent>,
    private fb: FormBuilder
  ) {
    this.kupci = []
  }



  ngOnInit() {
    this.mesta = this.metodeAPI.vratiMesta();
    //this.ulice = this.metodeAPI.vratiUliceZaMesto("Beograd");
    this.kupac = {
      pib: 0,
      naziv: "",
      adresa: {
        mesto: {
          mestoID: 0,
          naziv: "",
        },
        ulica: {
          ulicaID: 0,
          naziv: "",
          mesto: {
            mestoID: 0,
            naziv: "",
          }
        },
        broj: ""
      },
      telefon: "",
      email: ""
    }
  }



  kupacForma = this.fb.group({
    'pib': new FormControl(null, [Validators.required, Validators.pattern("^[0-9]*$"), Validators.minLength(9), Validators.maxLength(9)]),
    'naziv': new FormControl(null, Validators.required),
    'mesto': new FormControl(null, Validators.required),
    'ulica': new FormControl(null, Validators.required),
    'broj': new FormControl(null, Validators.required),
    'telefon': new FormControl(null, [Validators.required, Validators.pattern('(([+][(]?[0-9]{1,3}[)]?)|([(]?[0-9]{4}[)]?))\s*[)]?[-\s\.]?[(]?[0-9]{1,3}[)]?([-\s\.]?[0-9]{3})([-\s\.]?[0-9]{3,4})'), Validators.minLength(9)]),
    'email': new FormControl(null, [Validators.required, Validators.email])
  });

  onSubmitKupac() {
    const pomocniKupac = this.kupacForma.value;

    this.kupac.pib = +pomocniKupac.pib;
    this.kupac.naziv = pomocniKupac.naziv;
    this.kupac.adresa.mesto = pomocniKupac.mesto;
    this.kupac.adresa.ulica = pomocniKupac.ulica;
    this.kupac.adresa.broj = pomocniKupac.broj;
    this.kupac.telefon = pomocniKupac.telefon;
    this.kupac.email = pomocniKupac.email;

    const obj = {
      pib: this.kupac.pib,
      naziv: this.kupac.naziv,
      telefon: this.kupac.telefon,
      email: this.kupac.email,
      mesto: this.kupac.adresa.mesto,
      ulica: this.kupac.adresa.ulica,
      broj: this.kupac.adresa.broj
    }

    console.log(this.kupac);
    this.metodeAPI.unesiKupca(obj).subscribe(
      (data) => {
        console.log('Data:', data);
        alert("Kupac uspesno unet!")
      },
      (error) => {
        console.log('Error:', error);
        
      }
    );
      this.onReset();
  }

  azurirajKupca() {
    const pomocniKupac = this.kupacForma.value;

    this.kupac.pib = +pomocniKupac.pib;
    this.kupac.naziv = pomocniKupac.naziv;
    this.kupac.adresa.mesto = pomocniKupac.mesto;
    this.kupac.adresa.ulica = pomocniKupac.ulica;
    this.kupac.adresa.broj = pomocniKupac.broj;
    this.kupac.telefon = pomocniKupac.telefon;
    this.kupac.email = pomocniKupac.email;

    const obj = {
      pib: this.kupac.pib,
      naziv: this.kupac.naziv,
      telefon: this.kupac.telefon,
      email: this.kupac.email,
      mesto: this.kupac.adresa.mesto,
      ulica: this.kupac.adresa.ulica,
      broj: this.kupac.adresa.broj
    }

    console.log(this.kupac);
    this.metodeAPI.azurirajKupca(obj).subscribe(
      (data) => {
        console.log('Data:', data);
        alert("Kupac uspesno izmenjen!")
      },
      (error) => {
        console.log('Error:', error);
        alert("Kupac uspesno izmenjen!")
      }
    );
      this.kupacForma.reset();
  }



  pronadjiKupca() {
    this.pib = this.kupacForma.get('pib').value;
    if (this.pib === null) {
      alert("Unesite PIB kupca!")
    } else {
      console.log(this.pib)
      this.metodeAPI.vratiKupca(this.pib)
        .subscribe((data) => {
          typeof (data)
          this.kupac = data;
          if (data != null) {
            this.kupacForma.patchValue({
              pib: this.kupac.pib,
              naziv: this.kupac.naziv,
              mesto: this.kupac.adresa.mesto.naziv,
              ulica: this.kupac.adresa.ulica.naziv,
              broj: this.kupac.adresa.broj,
              telefon: this.kupac.telefon,
              email: this.kupac.email
            })
          }
          else {
            alert("Kupac ne postoji u bazi!");
            this.kupacForma.reset();
          }
        }
        );
    }
  }

  obrisiKupca() {
    this.pib = this.kupacForma.get('pib').value;
    if (this.pib === null) {
      alert("Unesite PIB kupca!")
    } else{
      console.log(this.pib)
      if(confirm("Da li želite da obrišete kupca sa PIB-om:  "+this.pib)) {
        this.metodeAPI.obrisiKupca(this.pib).subscribe((data) => {
          console.log("Data", data);
          alert("Kupac sa pibom:"+this.pib+" uspesno obrisan!")
          this.kupacForma.reset();
        }, (error) => {
          console.log("Error:", error)
          alert("Kupac sa pibom:"+this.pib+" uspesno obrisan!")
          this.kupacForma.reset();
        });
      }
    }
  }

  onReset() {
    this.kupacForma.reset();
  }

  public promenaMesta() {
    this.ulice = this.metodeAPI.vratiUliceZaMesto(this.kupacForma.value.mesto);
  }
}