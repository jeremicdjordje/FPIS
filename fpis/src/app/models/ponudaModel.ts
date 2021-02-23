import { KupacModel } from './kupacModel';
import { StavkaModel } from './stavkaModel';
import { TipModel } from './tipModel';
import { ZahtevModel } from './zahtevModel';

export class PonudaModel {
    public ponudaID: number;
    public datum: string;
    public kupac: KupacModel;
    public tip: TipModel;
    public zahtev: ZahtevModel;
    public listaStavki: StavkaModel[];

    constructor(json) {
        Object.assign(this, json);
    }
}

