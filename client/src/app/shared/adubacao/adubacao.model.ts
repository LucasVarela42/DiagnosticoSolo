export class Laudo {
    public id?: number;
    public nome: string;
    public responsavel: string;
    public diagnostico?: Diagnostico;
    public argila: number;
    public pH: number;
    public pHReferencia: number;
    public indiceSMP: number;
    public fosforoP: number;
    public potassioK: number;
    public materiaOrganicaMO: number;
    public aluminioTrocavelAlTroc: number;
    public calcioTrocavelCaTroc: number;
    public magnesioTrocavelMgTroc: number;
    public aluminioHidrogenioALplusH: number;
    public CTC: number;
    public saturacaoCTC: number;
    public relacaoCaMg: number;
    public relacaoCaK: number;
    public relacaoMgK: number;

    constructor(laudo: Laudo){
        this.id = laudo.id;
        this.nome = laudo.nome;
        this.responsavel = laudo.responsavel;
        this.argila = laudo.argila;
        this.pH = laudo.pH;
        this.pHReferencia = laudo.pHReferencia;
        this.indiceSMP = laudo.indiceSMP;
        this.fosforoP = laudo.fosforoP;
        this.potassioK = laudo.potassioK;
        this.materiaOrganicaMO = laudo.materiaOrganicaMO;
        this.aluminioTrocavelAlTroc = laudo.aluminioTrocavelAlTroc;
        this.calcioTrocavelCaTroc = laudo.calcioTrocavelCaTroc;
        this.magnesioTrocavelMgTroc = laudo.magnesioTrocavelMgTroc;
        this.aluminioHidrogenioALplusH = laudo.aluminioHidrogenioALplusH;
        this.CTC = laudo.CTC;
        this.saturacaoCTC = laudo.saturacaoCTC;
        this.relacaoCaMg = laudo.relacaoCaMg;
        this.relacaoCaK = laudo.relacaoCaK;
        this.relacaoMgK = laudo.relacaoMgK;
    }
}

export class Diagnostico {
    public id?: number;
    public laudo: Laudo;
    public faixaAzidez: number;
    public tipoCalcario: number;
    public quantidadceCalcario: number;
    public finalidadeAdubacao: number;
    public recomendacao: string;
}
