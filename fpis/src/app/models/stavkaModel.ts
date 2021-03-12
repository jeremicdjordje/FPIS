import { ProizvodModel } from "./proizvodModel";

export class StavkaModel{
    rb_stavke: number;
    proizvod: ProizvodModel;
    kolicina: number;
    

    constructor(json) {
        Object.assign(this, json);
    }
}