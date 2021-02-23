export class JedinicaMereModel{
    public jmID: number;
    public oznaka: string;
    public naziv: string;
    
    constructor(json){
        Object.assign(this, json);
    }
}