export class Laudo {
    public id?: string;
    public nome: string;
    public responsavel: string;
    public diagnostico?: Diagnostico;
    public argila: number;
    public pH: number;
    public indiceSMP: number;
    public fosforoP: number;
    public potassioK: number;
    public materiaOrganicaMO: number;
    public aluminioTrocavelAlTroc: number;
    public calcioTrocavelCaTroc: number;
    public magnesioTrocavelMgTroc: number;
    public aluminioHidrogenioALplusH: number;
    public ctc: number;
    public saturacaoCTCBase: number;
    public saturacaoCTCAl: number;
    public relacaoCaMg: number;
    public relacaoCaK: number;
    public relacaoMgK: number;
    public pHReferencia: number;

    constructor(laudo: Laudo){
        this.id = laudo.id;
        this.nome = laudo.nome;
        this.responsavel = laudo.responsavel;
        this.argila = laudo.argila;
        this.pH = laudo.pH;
        this.indiceSMP = laudo.indiceSMP;
        this.fosforoP = laudo.fosforoP;
        this.potassioK = laudo.potassioK;
        this.materiaOrganicaMO = laudo.materiaOrganicaMO;
        this.aluminioTrocavelAlTroc = laudo.aluminioTrocavelAlTroc;
        this.calcioTrocavelCaTroc = laudo.calcioTrocavelCaTroc;
        this.magnesioTrocavelMgTroc = laudo.magnesioTrocavelMgTroc;
        this.aluminioHidrogenioALplusH = laudo.aluminioHidrogenioALplusH;
        this.ctc = laudo.ctc;
        this.saturacaoCTCBase = laudo.saturacaoCTCBase;
        this.saturacaoCTCAl = laudo.saturacaoCTCAl;
        this.relacaoCaMg = laudo.relacaoCaMg;
        this.relacaoCaK = laudo.relacaoCaK;
        this.relacaoMgK = laudo.relacaoMgK;
        this.pHReferencia = laudo.pHReferencia;
    }
}

export class Diagnostico {
    public id?: string;
    public laudo: Laudo;
    public faixaAcidez: number;
    public tipoCalcario: number;
    public quantidadeCalcario: number;
    public finalidadeAdubacao: number;
    public recomendacao: string;
}
