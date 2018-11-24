package br.edu.ifsc.adubacao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "diagnosticos")
public class Diagnostico {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "laudo_id", nullable = false)
    private Laudo laudo;

    @Column(name = "faixa_acidez")
    private double faixaAcidez;
    @Column(name = "tipo_calcario")
    private int tipoCalcario;
    @Column(name = "quantidade_calcario")
    private double quantidadeCalcario;
    @Column(name = "finalidade_adubacao")
    private int finalidadeAdubacao;
    @Column(name = "recomendacao")
    private String recomendacao;

    public Diagnostico() {
    }

    public Diagnostico(Laudo laudo, double faixaAcidez, int tipoCalcario, double quantidadeCalcario, int finalidadeAdubacao, String recomendacao) {
        this.laudo = laudo;
        this.faixaAcidez = faixaAcidez;
        this.tipoCalcario = tipoCalcario;
        this.quantidadeCalcario = quantidadeCalcario;
        this.finalidadeAdubacao = finalidadeAdubacao;
        this.recomendacao = recomendacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

    public double getFaixaAcidez() {
        return faixaAcidez;
    }

    public void setFaixaAcidez(double faixaAcidez) {
        this.faixaAcidez = faixaAcidez;
    }

    public int getTipoCalcario() {
        return tipoCalcario;
    }

    public void setTipoCalcario(int tipoCalcario) {
        this.tipoCalcario = tipoCalcario;
    }

    public double getQuantidadeCalcario() {
        return quantidadeCalcario;
    }

    public void setQuantidadeCalcario(double quantidadeCalcario) {
        this.quantidadeCalcario = quantidadeCalcario;
    }

    public int getFinalidadeAdubacao() {
        return finalidadeAdubacao;
    }

    public void setFinalidadeAdubacao(int finalidadeAdubacao) {
        this.finalidadeAdubacao = finalidadeAdubacao;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    public void calcularQuantidadeCalcario(double nc){
        quantidadeCalcario = (( (nc*1.5) * 100) / 0.9) / 100;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "id=" + id +
                ", laudo=" + laudo +
                ", faixaAcidez=" + faixaAcidez +
                ", tipoCalcario=" + tipoCalcario +
                ", quantidadeCalcario=" + quantidadeCalcario +
                ", finalidadeAdubacao=" + finalidadeAdubacao +
                ", recomendacao='" + recomendacao + '\'' +
                '}';
    }
}
