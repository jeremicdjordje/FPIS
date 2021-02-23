import { MestoModel } from './mestoModel';
import { UlicaModel } from './ulicaModel';

export class KupacModel{
    public pib: number;
    public naziv: string;
    public adresa: Adresa;
    public telefon: string;
    public email: string;

    constructor(json){
        Object.assign(this, json);
    }
}

export class Adresa {
    public mesto: MestoModel;
    public ulica: UlicaModel;
    public broj: string;
}