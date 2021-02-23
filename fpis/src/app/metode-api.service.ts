import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { KupacModel } from './models/kupacModel';
import { MestoModel } from './models/mestoModel';
import { UlicaModel } from './models/ulicaModel';
import { TipModel } from './models/tipModel';
import { ProizvodModel } from './models/proizvodModel';
import { catchError, map } from 'rxjs/operators';
import { PonudaModel } from './models/ponudaModel';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class MetodeAPIService {
  ponude;
  kupci;


  private selectedRowIndex: number;

  constructor(private http: HttpClient) { }


  //kupac

  unesiKupca(kupac) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log('Kreiraj kupca:', kupac);
    return this.http.post<any>('http://localhost:8082/kupac/dodaj/', kupac,
      { headers: headers }
    ).pipe(map((res) => {
      return res as KupacModel;
    }));
  }

  azurirajKupca(kupac) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log('Izmeni kupca', kupac);
    return this.http.put<any>('http://localhost:8082/kupac/azuriraj', kupac,
      { headers: headers }
    ).pipe(map((res) => {
      return res as KupacModel;
    }));
  }

  vratiKupca(pib) {
    return this.http.get<KupacModel>('http://localhost:8082/kupac/pronadji-po-pibu?pib=' + pib)
      .pipe(
        map((res) => {
          return res as KupacModel;
        })
      );
  }

  vratiKupce(){
    return this.http.get<KupacModel[]>('http://localhost:8082/kupac/svi/');
  }

  obrisiKupca(pib) {
    return this.http.delete('http://localhost:8082/kupac/obrisi?pib=' + pib);
  }

  //stavke

  dodajStavku(stavka) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log('Dodaj stavku', stavka);
    return this.http.post<any>('http://localhost:8082/stavka-ponude/dodaj', stavka, { headers: headers }
    );
  }

  obrisiStavku(rb) {
    console.log("Podaci koje brises:", rb)
    return this.http.delete('http://localhost:8082/stavka-ponude/obrisi/' + rb);
  }

  azurirajStavku(stavka) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log('Izmeni stavku', stavka);
    return this.http.post<any>('http://localhost:8082/stavka-ponude/azuriraj', stavka, { headers: headers }
    );
  }

  //ponuda

  unesiPonudu(ponuda) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log('Kreiraj ponudu:', ponuda);
    return this.http.post<any>('http://localhost:8082/ponuda/dodaj', ponuda, { headers: headers }
    ).pipe(
      map(
        (res) => {
          return res as PonudaModel;
        })
    );
  }

  azurirajPonudu(ponuda) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    console.log('Izmeni ponudu', ponuda);
    return this.http.put<any>('http://localhost:8082/ponuda/azuriraj', ponuda, { headers: headers }
    ).pipe(
      map(
        (res) => {
          return res as PonudaModel;
        })
    );
  }

  vratiPonude() {
    return this.http.get<PonudaModel[]>('http://localhost:8082/ponuda/sve/').pipe(
      map(
        (res) => {
          return res as PonudaModel[];
        })
    );
  }

  vratiPonuduPoID(brojPonude) {
    return this.http.get<PonudaModel>('http://localhost:8082/ponuda/pronadji-po-id?id='+brojPonude).pipe(
      map(
        (res) => {
          return res as PonudaModel;
        })
    );
  }

  vratiIDPonude() {
    return this.http.get<any>('http://localhost:8082/ponuda/vrati-id');
  }

  obrisiPonudu(brojPonude) {
    return this.http.delete('http://localhost:8082/ponuda/obrisi?ponudaID=' + brojPonude);
  }

  //combobox

  vratiMesta() {
    return this.http.get<MestoModel[]>('http://localhost:8082/mesto/sva/');
  }

  vratiUlice() : Observable<UlicaModel[]>{
    return this.http.get<UlicaModel[]>('http://localhost:8082/ulica/sve/');
  }

  vratiUliceZaMesto(nazivMesta) : Observable<UlicaModel[]>{
    return this.http.get<UlicaModel[]>('http://localhost:8082/ulica/pronadji-za-mesto?naziv='+nazivMesta).pipe(
      map(
        (res) => {
          return res as UlicaModel[];
        })
    );
  }

  vratiTipove(){
    return this.http.get<TipModel[]>('http://localhost:8082/tip/svi/');
  }

  vratiProizvode()  {
    return this.http.get<ProizvodModel[]>('http://localhost:8082/proizvod/svi/');
  }
}