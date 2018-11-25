package br.edu.ifsc.adubacao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;

@Document(collection="laudos")
@JsonIgnoreProperties(value = {"diagnostico"}, allowGetters = true)
public class Laudo {
    @Id
    private String id;

    private String nome;
    @NotBlank
    private String responsavel;

    @JsonIgnore
    private Diagnostico diagnostico;

    private double argila;
    private double pH;
    private double indiceSMP;
    private double fosforoP;
    private double potassioK;
    private double materiaOrganicaMO;
    private double aluminioTrocavelAlTroc;
    private double calcioTrocavelCaTroc;
    private double magnesioTrocavelMgTroc;

    private double aluminioHidrogenioALplusH;
    private double ctc;
    private double saturacaoCTCBase;
    private double saturacaoCTCAl;
    private double relacaoCaMg;
    private double relacaoCaK;
    private double relacaoMgK;

    private double pHReferencia;

    public Laudo() {
    }

    public Laudo(String id, String nome, @NotBlank String responsavel, Diagnostico diagnostico, double argila, double pH, double indiceSMP, double fosforoP, double potassioK, double materiaOrganicaMO, double aluminioTrocavelAlTroc, double calcioTrocavelCaTroc, double magnesioTrocavelMgTroc, double aluminioHidrogenioALplusH, double ctc, double saturacaoCTCBase, double saturacaoCTCAl, double relacaoCaMg, double relacaoCaK, double relacaoMgK, double pHReferencia) {
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
        this.diagnostico = diagnostico;
        this.argila = argila;
        this.pH = pH;
        this.indiceSMP = indiceSMP;
        this.fosforoP = fosforoP;
        this.potassioK = potassioK;
        this.materiaOrganicaMO = materiaOrganicaMO;
        this.aluminioTrocavelAlTroc = aluminioTrocavelAlTroc;
        this.calcioTrocavelCaTroc = calcioTrocavelCaTroc;
        this.magnesioTrocavelMgTroc = magnesioTrocavelMgTroc;
        this.aluminioHidrogenioALplusH = aluminioHidrogenioALplusH;
        this.ctc = ctc;
        this.saturacaoCTCBase = saturacaoCTCBase;
        this.saturacaoCTCAl = saturacaoCTCAl;
        this.relacaoCaMg = relacaoCaMg;
        this.relacaoCaK = relacaoCaK;
        this.relacaoMgK = relacaoMgK;
        this.pHReferencia = pHReferencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @JsonIgnore
    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public double getArgila() {
        return argila;
    }

    public void setArgila(double argila) {
        this.argila = argila;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public double getIndiceSMP() {
        return indiceSMP;
    }

    public void setIndiceSMP(double indiceSMP) {
        this.indiceSMP = indiceSMP;
    }

    public double getFosforoP() {
        return fosforoP;
    }

    public void setFosforoP(double fosforoP) {
        this.fosforoP = fosforoP;
    }

    public double getPotassioK() {
        return potassioK;
    }

    public void setPotassioK(double potassioK) {
        this.potassioK = potassioK;
    }

    public double getMateriaOrganicaMO() {
        return materiaOrganicaMO;
    }

    public void setMateriaOrganicaMO(double materiaOrganicaMO) {
        this.materiaOrganicaMO = materiaOrganicaMO;
    }

    public double getAluminioTrocavelAlTroc() {
        return aluminioTrocavelAlTroc;
    }

    public void setAluminioTrocavelAlTroc(double aluminioTrocavelAlTroc) {
        this.aluminioTrocavelAlTroc = aluminioTrocavelAlTroc;
    }

    public double getCalcioTrocavelCaTroc() {
        return calcioTrocavelCaTroc;
    }

    public void setCalcioTrocavelCaTroc(double calcioTrocavelCaTroc) {
        this.calcioTrocavelCaTroc = calcioTrocavelCaTroc;
    }

    public double getMagnesioTrocavelMgTroc() {
        return magnesioTrocavelMgTroc;
    }

    public void setMagnesioTrocavelMgTroc(double magnesioTrocavelMgTroc) {
        this.magnesioTrocavelMgTroc = magnesioTrocavelMgTroc;
    }

    public double getAluminioHidrogenioALplusH() {
        return aluminioHidrogenioALplusH;
    }

    public void setAluminioHidrogenioALplusH(double aluminioHidrogenioALplusH) {
        this.aluminioHidrogenioALplusH = aluminioHidrogenioALplusH;
    }

    public double getCtc() {
        return ctc;
    }

    public void setCtc(double ctc) {
        this.ctc = ctc;
    }

    public double getSaturacaoCTCBase() {
        return saturacaoCTCBase;
    }

    public void setSaturacaoCTCBase(double saturacaoCTCBase) {
        this.saturacaoCTCBase = saturacaoCTCBase;
    }

    public double getSaturacaoCTCAl() {
        return saturacaoCTCAl;
    }

    public void setSaturacaoCTCAl(double saturacaoCTCAl) {
        this.saturacaoCTCAl = saturacaoCTCAl;
    }

    public double getRelacaoCaMg() {
        return relacaoCaMg;
    }

    public void setRelacaoCaMg(double relacaoCaMg) {
        this.relacaoCaMg = relacaoCaMg;
    }

    public double getRelacaoCaK() {
        return relacaoCaK;
    }

    public void setRelacaoCaK(double relacaoCaK) {
        this.relacaoCaK = relacaoCaK;
    }

    public double getRelacaoMgK() {
        return relacaoMgK;
    }

    public void setRelacaoMgK(double relacaoMgK) {
        this.relacaoMgK = relacaoMgK;
    }

    public double getpHReferencia() {
        return pHReferencia;
    }

    public void setpHReferencia(double pHReferencia) {
        this.pHReferencia = pHReferencia;
    }

    @Override
    public String toString() {
        return "Laudo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", diagnostico=" + diagnostico +
                ", argila=" + argila +
                ", pH=" + pH +
                ", indiceSMP=" + indiceSMP +
                ", fosforoP=" + fosforoP +
                ", potassioK=" + potassioK +
                ", materiaOrganicaMO=" + materiaOrganicaMO +
                ", aluminioTrocavelAlTroc=" + aluminioTrocavelAlTroc +
                ", calcioTrocavelCaTroc=" + calcioTrocavelCaTroc +
                ", magnesioTrocavelMgTroc=" + magnesioTrocavelMgTroc +
                ", aluminioHidrogenioALplusH=" + aluminioHidrogenioALplusH +
                ", ctc=" + ctc +
                ", saturacaoCTCBase=" + saturacaoCTCBase +
                ", saturacaoCTCAl=" + saturacaoCTCAl +
                ", relacaoCaMg=" + relacaoCaMg +
                ", relacaoCaK=" + relacaoCaK +
                ", relacaoMgK=" + relacaoMgK +
                ", pHReferencia=" + pHReferencia +
                '}';
    }
}
