export class Laudo {
    id?: number;
    nome: string;
    responsavel: string;
    diagnostico?: Diagnostico;
    argila: number;
    pH: number;
    pHReferencia: number;
    indiceSMP: number;
    fosforoP: number;
    potassioK: number;
    materiaOrganicaMO: number;
    aluminioTrocavelAlTroc: number;
    calcioTrocavelCaTroc: number;
    magnesioTrocavelMgTroc: number;
    aluminioHidrogenioALplusH: number;
    CTC: number;
    saturacaoCTC: number;
    relacaoCaMg: number;
    relacaoCaK: number;
    relacaoMgK: number;
}

export class Diagnostico {
    id?: number;
    laudo: Laudo;
    faixaAzidez: number;
    tipoCalcario: number;
    quantidadceCalcario: number;
    finalidadeAdubacao: number;
    recomendacao: string;
}
