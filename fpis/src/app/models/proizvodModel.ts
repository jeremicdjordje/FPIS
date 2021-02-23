import { JedinicaMereModel } from "./jedinicaMereModel";

export class ProizvodModel{
    public proizvodID: number;
    public naziv: string;
    public jedinicaMere: JedinicaMereModel;
    
    constructor(json){
        Object.assign(this, json);
    }
}