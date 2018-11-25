package br.edu.ifsc.adubacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="diagnosticos")
@JsonIgnoreProperties(allowGetters = true)
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

    public void calcularQuantidadeCalcario(double nc){
        quantidadeCalcario100 = (( (nc*1.5) * 100) / 1) / 100;
        quantidadeCalcario85 = (( (nc*1.5) * 100) / 0.85) / 100;
        quantidadeCalcario75 = (( (nc*1.5) * 100) / 0.75) / 100;
        quantidadeCalcario65 = (( (nc*1.5) * 100) / 0.65) / 100;
    }




}
