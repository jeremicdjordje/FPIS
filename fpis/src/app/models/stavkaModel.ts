import { ProizvodModel } from "./proizvodModel";

export class StavkaModel{
    rb: number;
    proizvod: ProizvodModel;
    kolicina: number;
    

    constructor(json) {
        Object.assign(this, json);
    }
}