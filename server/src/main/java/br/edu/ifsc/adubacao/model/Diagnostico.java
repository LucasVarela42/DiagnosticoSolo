package br.edu.ifsc.adubacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="diagnosticos")
public class Diagnostico {
    @Id
    private String id;
    private Laudo laudo;
    private double quantidadeCalcario100;
    private double quantidadeCalcario85;
    private double quantidadeCalcario75;
    private double quantidadeCalcario65;
    private double quantidadeFosforoP;
    private double quantidadePotassioK;
    private int classeArgila;
    private String classeMO;
    private String classeCTC;
    private String classeFosforoP;
    private String classePotassioK;
    private String classeCalcioCa;
    private String classeMagnesioMg;

    public Diagnostico() {
    }

    public Diagnostico(String id, Laudo laudo, double quantidadeCalcario100, double quantidadeCalcario85, double quantidadeCalcario75, double quantidadeCalcario65, double quantidadeFosforoP, double quantidadePotassioK, int classeArgila, String classeMO, String classeCTC, String classeFosforoP, String classePotassioK, String classeCalcioCa, String classeMagnesioMg) {
        this.id = id;
        this.laudo = laudo;
        this.quantidadeCalcario100 = quantidadeCalcario100;
        this.quantidadeCalcario85 = quantidadeCalcario85;
        this.quantidadeCalcario75 = quantidadeCalcario75;
        this.quantidadeCalcario65 = quantidadeCalcario65;
        this.quantidadeFosforoP = quantidadeFosforoP;
        this.quantidadePotassioK = quantidadePotassioK;
        this.classeArgila = classeArgila;
        this.classeMO = classeMO;
        this.classeCTC = classeCTC;
        this.classeFosforoP = classeFosforoP;
        this.classePotassioK = classePotassioK;
        this.classeCalcioCa = classeCalcioCa;
        this.classeMagnesioMg = classeMagnesioMg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

    public double getQuantidadeCalcario100() {
        return quantidadeCalcario100;
    }

    public void setQuantidadeCalcario100(double quantidadeCalcario100) {
        this.quantidadeCalcario100 = quantidadeCalcario100;
    }

    public double getQuantidadeCalcario85() {
        return quantidadeCalcario85;
    }

    public void setQuantidadeCalcario85(double quantidadeCalcario85) {
        this.quantidadeCalcario85 = quantidadeCalcario85;
    }

    public double getQuantidadeCalcario75() {
        return quantidadeCalcario75;
    }

    public void setQuantidadeCalcario75(double quantidadeCalcario75) {
        this.quantidadeCalcario75 = quantidadeCalcario75;
    }

    public double getQuantidadeCalcario65() {
        return quantidadeCalcario65;
    }

    public void setQuantidadeCalcario65(double quantidadeCalcario65) {
        this.quantidadeCalcario65 = quantidadeCalcario65;
    }

    public double getQuantidadeFosforoP() {
        return quantidadeFosforoP;
    }

    public void setQuantidadeFosforoP(double quantidadeFosforoP) {
        this.quantidadeFosforoP = quantidadeFosforoP;
    }

    public double getQuantidadePotassioK() {
        return quantidadePotassioK;
    }

    public void setQuantidadePotassioK(double quantidadePotassioK) {
        this.quantidadePotassioK = quantidadePotassioK;
    }

    public int getClasseArgila() {
        return classeArgila;
    }

    public void setClasseArgila(int classeArgila) {
        this.classeArgila = classeArgila;
    }

    public String getClasseMO() {
        return classeMO;
    }

    public void setClasseMO(String classeMO) {
        this.classeMO = classeMO;
    }

    public String getClasseCTC() {
        return classeCTC;
    }

    public void setClasseCTC(String classeCTC) {
        this.classeCTC = classeCTC;
    }

    public String getClasseFosforoP() {
        return classeFosforoP;
    }

    public void setClasseFosforoP(String classeFosforoP) {
        this.classeFosforoP = classeFosforoP;
    }

    public String getClassePotassioK() {
        return classePotassioK;
    }

    public void setClassePotassioK(String classePotassioK) {
        this.classePotassioK = classePotassioK;
    }

    public String getClasseCalcioCa() {
        return classeCalcioCa;
    }

    public void setClasseCalcioCa(String classeCalcioCa) {
        this.classeCalcioCa = classeCalcioCa;
    }

    public String getClasseMagnesioMg() {
        return classeMagnesioMg;
    }

    public void setClasseMagnesioMg(String classeMagnesioMg) {
        this.classeMagnesioMg = classeMagnesioMg;
    }

    public void calcularQuantidadeCalcario(double nc){
        this.quantidadeCalcario100 = (( (nc*1.5) * 100) / 1) / 100;
        this.quantidadeCalcario85 = (( (nc*1.5) * 100) / 0.85) / 100;
        this.quantidadeCalcario75 = (( (nc*1.5) * 100) / 0.75) / 100;
        this.quantidadeCalcario65 = (( (nc*1.5) * 100) / 0.65) / 100;
    }

    public void calcularTeorPotassioK() {
        String classeCtc = this.classeCTC;
        double potassioK = this.laudo.getPotassioK();

        if(classeCtc.equals("Baixo")&&(potassioK <= 20))
        this.classePotassioK = "Muito Baixo";

        if(classeCtc.equals("Médio")&&(potassioK <= 30))
        this.classePotassioK = "Muito Baixo";

        if(classeCtc.equals("Alto")&&(potassioK <= 40))
        this.classePotassioK = "Muito Baixo";

        if(classeCtc.equals("Muito Alto")&&(potassioK <= 45))
        this.classePotassioK = "Muito Baixo";

        if(classeCtc.equals("Baixo")&&(potassioK >= 21 && potassioK <= 40))
        this.classePotassioK = "Baixo";

        if(classeCtc.equals("Médio")&&(potassioK >= 31 && potassioK <= 60))
        this.classePotassioK = "Baixo";

        if(classeCtc.equals("Alto")&&(potassioK >= 41 && potassioK <= 80))
        this.classePotassioK = "Baixo";

        if(classeCtc.equals("Muito Alto")&&(potassioK >= 46 && potassioK <= 90))
        this.classePotassioK = "Baixo";

        if(classeCtc.equals("Baixo")&&(potassioK >= 41 && potassioK <= 60))
        this.classePotassioK = "Médio";

        if(classeCtc.equals("Médio")&&(potassioK >= 61 && potassioK <= 90))
        this.classePotassioK = "Médio";

        if(classeCtc.equals("Alto")&&(potassioK >= 81 && potassioK <= 120))
        this.classePotassioK = "Médio";

        if(classeCtc.equals("Muito Alto")&&(potassioK >= 91 && potassioK <= 135))
        this.classePotassioK = "Médio";

        if(classeCtc.equals("Baixo")&&(potassioK >= 61 && potassioK <= 120))
        this.classePotassioK = "Alto";

        if(classeCtc.equals("Médio")&&(potassioK >= 91 && potassioK <= 180))
        this.classePotassioK = "Alto";

        if(classeCtc.equals("Alto")&&(potassioK >= 121 && potassioK <= 240))
        this.classePotassioK = "Alto";

        if(classeCtc.equals("Muito Alto")&&(potassioK >= 136 && potassioK <= 270))
        this.classePotassioK = "Alto";

        if(classeCtc.equals("Baixo")&&(potassioK > 120))
        this.classePotassioK = "Muito Alto";

        if(classeCtc.equals("Médio")&&(potassioK > 180))
        this.classePotassioK = "Muito Alto";

        if(classeCtc.equals("Alto")&&(potassioK > 240))
        this.classePotassioK = "Muito Alto";

        if(classeCtc.equals("Muito Alto")&&(potassioK > 270))
        this.classePotassioK = "Muito Alto";
    }

    public void calcularQuantidadeFosforoP() {
        if(this.classeFosforoP.equals("Muito Baixo"))
            quantidadeFosforoP = 250;
        if(this.classeFosforoP.equals("Baixo"))
            quantidadeFosforoP = 170;
        if(this.classeFosforoP.equals("Médio"))
            quantidadeFosforoP = 130;
        if(this.classeFosforoP.equals("Alto"))
            quantidadeFosforoP = 90;
        if(this.classeFosforoP.equals("Muito Alto"))
            quantidadeFosforoP = 0;
    }

    public void calcularQuantidadePotassioK() {
        if(this.classePotassioK.equals("Muito Baixo"))
            quantidadePotassioK = 150;
        if(this.classePotassioK.equals("Baixo"))
            quantidadePotassioK = 90;
        if(this.classePotassioK.equals("Médio"))
            quantidadePotassioK = 60;
        if(this.classePotassioK.equals("Alto"))
            quantidadePotassioK = 30;
        if(this.classePotassioK.equals("Muito Alto"))
            quantidadePotassioK = 0;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "id='" + id + '\'' +
                ", laudo=" + laudo +
                ", quantidadeCalcario100=" + quantidadeCalcario100 +
                ", quantidadeCalcario85=" + quantidadeCalcario85 +
                ", quantidadeCalcario75=" + quantidadeCalcario75 +
                ", quantidadeCalcario65=" + quantidadeCalcario65 +
                ", quantidadeFosforoP=" + quantidadeFosforoP +
                ", quantidadePotassioK=" + quantidadePotassioK +
                ", classeArgila=" + classeArgila +
                ", classeMO='" + classeMO + '\'' +
                ", classeCTC='" + classeCTC + '\'' +
                ", classeFosforoP='" + classeFosforoP + '\'' +
                ", classePotassioK='" + classePotassioK + '\'' +
                ", classeCalcioCa='" + classeCalcioCa + '\'' +
                ", classeMagnesioMg='" + classeMagnesioMg + '\'' +
                '}';
    }
}
