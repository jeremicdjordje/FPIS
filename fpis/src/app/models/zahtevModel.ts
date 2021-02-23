export class ZahtevModel{
    public zahtevID: number;
    public datum: string;
    
    constructor(json){
        Object.assign(this, json);
    }
}