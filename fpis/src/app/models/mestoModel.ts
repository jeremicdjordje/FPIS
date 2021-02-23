export class MestoModel{
    public mestoID: number;
    public naziv: string;
    
    constructor(json){
        Object.assign(this, JSON);
    }
}