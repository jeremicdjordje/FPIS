import { MestoModel } from './mestoModel';

export class UlicaModel{
    public ulicaID: number;
    public mesto: MestoModel;
    public naziv: string;
    
    constructor(json){
        Object.assign(this, json);
    }
}