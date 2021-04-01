import { ProizvodModel } from "./proizvodModel";

export class StavkaModel{
    rb_stavke: number;
    // proizvod: ProizvodModel;
    kolicina: number;
    nazivProizvoda: string;
    jedinicaMere: string;
    

    constructor(json) {
        Object.assign(this, json);
    }
}