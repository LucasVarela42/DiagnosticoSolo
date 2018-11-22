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
    private double faixaAzidez;
    @Column(name = "tipo_calcario")
    private int tipoCalcario;
    @Column(name = "quantidade_calcario")
    private double quantidadceCalcario;
    @Column(name = "finalidade_adubacao")
    private int finalidadeAdubacao;
    @Column(name = "recomendacao")
    private String recomendacao;

    public Diagnostico(Laudo laudo, double faixaAzidez, int tipoCalcario, double quantidadceCalcario, int finalidadeAdubacao, String recomendacao) {
        this.laudo = laudo;
        this.faixaAzidez = faixaAzidez;
        this.tipoCalcario = tipoCalcario;
        this.quantidadceCalcario = quantidadceCalcario;
        this.finalidadeAdubacao = finalidadeAdubacao;
        this.recomendacao = recomendacao;
    }

    public Diagnostico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFaixaAzidez() {
        return faixaAzidez;
    }

    public void setFaixaAzidez(double faixaAzidez) {
        this.faixaAzidez = faixaAzidez;
    }

    public int getTipoCalcario() {
        return tipoCalcario;
    }

    public void setTipoCalcario(int tipoCalcario) {
        this.tipoCalcario = tipoCalcario;
    }

    public double getQuantidadceCalcario() {
        return quantidadceCalcario;
    }

    public void setQuantidadceCalcario(double quantidadceCalcario) {
        this.quantidadceCalcario = quantidadceCalcario;
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

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }

    public void calcularQuantidadeCalcario(double nc){
        double qc = (( (nc*1.5) * 100) / 0.9) / 100;
        String result = new DecimalFormat("#.00").format(qc);
        quantidadceCalcario = Double.valueOf(result);
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "id=" + id +
                ", faixaAzidez=" + faixaAzidez +
                ", tipoCalcario=" + tipoCalcario +
                ", quantidadceCalcario=" + quantidadceCalcario +
                ", finalidadeAdubacao=" + finalidadeAdubacao +
                ", recomendacao='" + recomendacao + '\'' +
                '}';
    }
}
