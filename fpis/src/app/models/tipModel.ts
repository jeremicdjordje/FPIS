export class TipModel{
    public tipPlacanjaID: number;
    public naziv: string;
    
    constructor(json){
        Object.assign(this, json);
    }
}