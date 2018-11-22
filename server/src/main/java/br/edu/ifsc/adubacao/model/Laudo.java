package br.edu.ifsc.adubacao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "laudos")
public class Laudo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;
    @NotNull
    @Column(name = "responsavel")
    private String responsavel;

    @JsonIgnore
    @OneToOne(mappedBy = "laudo")
    private Diagnostico diagnostico;

    @Column(name = "argila")
    private double argila;
    @Column(name = "ph")
    private double pH;
    @Column(name = "ph_referencia")
    private double pHReferencia;
    @Column(name = "indice_smp")
    private double indiceSMP;
    @Column(name = "fosforo_p")
    private double fosforoP;
    @Column(name = "potassio_k")
    private double potassioK;
    @Column(name = "materia_organica_mo")
    private double materiaOrganicaMO;
    @Column(name = "aluminio_trocavel_al_troc")
    private double aluminioTrocavelAlTroc;
    @Column(name = "calcio_trocavel_ca_troc")
    private double calcioTrocavelCaTroc;
    @Column(name = "magnesio_trocavel_mg_troc")
    private double magnesioTrocavelMgTroc;

    @Column(name = "aluminio_hidrogenio_al_plus_h")
    private double aluminioHidrogenioALplusH;
    @Column(name = "ctc")
    private double CTC;
    @Column(name = "saturacao_ctc")
    private double saturacaoCTC;
    @Column(name = "relacao_ca_mg")
    private double relacaoCaMg;
    @Column(name = "relacao_ca_k")
    private double relacaoCaK;
    @Column(name = "relacao_mg_k")
    private double relacaoMgK;

    public Laudo() {
    }

    public Laudo(String nome, @NotNull String responsavel, Diagnostico diagnostico, double argila, double pH, double pHReferencia, double indiceSMP, double fosforoP, double potassioK, double materiaOrganicaMO, double aluminioTrocavelAlTroc, double calcioTrocavelCaTroc, double magnesioTrocavelMgTroc, double aluminioHidrogenioALplusH, double CTC, double saturacaoCTC, double relacaoCaMg, double relacaoCaK, double relacaoMgK) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.diagnostico = diagnostico;
        this.argila = argila;
        this.pH = pH;
        this.pHReferencia = pHReferencia;
        this.indiceSMP = indiceSMP;
        this.fosforoP = fosforoP;
        this.potassioK = potassioK;
        this.materiaOrganicaMO = materiaOrganicaMO;
        this.aluminioTrocavelAlTroc = aluminioTrocavelAlTroc;
        this.calcioTrocavelCaTroc = calcioTrocavelCaTroc;
        this.magnesioTrocavelMgTroc = magnesioTrocavelMgTroc;
        this.aluminioHidrogenioALplusH = aluminioHidrogenioALplusH;
        this.CTC = CTC;
        this.saturacaoCTC = saturacaoCTC;
        this.relacaoCaMg = relacaoCaMg;
        this.relacaoCaK = relacaoCaK;
        this.relacaoMgK = relacaoMgK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getpHReferencia() {
        return pHReferencia;
    }

    public void setpHReferencia(double pHReferencia) {
        this.pHReferencia = pHReferencia;
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

    public double getCTC() {
        return CTC;
    }

    public void setCTC(double CTC) {
        this.CTC = CTC;
    }

    public double getSaturacaoCTC() {
        return saturacaoCTC;
    }

    public void setSaturacaoCTC(double saturacaoCTC) {
        this.saturacaoCTC = saturacaoCTC;
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
                ", CTC=" + CTC +
                ", saturacaoCTC=" + saturacaoCTC +
                ", relacaoCaMg=" + relacaoCaMg +
                ", relacaoCaK=" + relacaoCaK +
                ", relacaoMgK=" + relacaoMgK +
                '}';
    }
}
