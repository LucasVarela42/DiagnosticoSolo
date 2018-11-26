package br.edu.ifsc.adubacao.service;

import br.edu.ifsc.adubacao.model.Diagnostico;
import br.edu.ifsc.adubacao.model.Laudo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AdubacaoServiceIntegrationTest {

    private AdubacaoService adubacaoService;

    @Before
    public void setup() {
        adubacaoService = new AdubacaoService();
    }

    @Test
    public void whenCriteriaMatching_ThenSetQuantidadeCalcario() throws IOException {
        Laudo laudo = new Laudo();
        laudo.setId("1");
        laudo.setResponsavel("Lucas");
        laudo.setIndiceSMP(5.2);
        laudo.setpHReferencia(6.5);
        Diagnostico diagnostico = new Diagnostico();
        adubacaoService.diagnosticoIndiceSMP(laudo, diagnostico);
        Assert.assertEquals(16.950000000000003, diagnostico.getQuantidadeCalcario100(), 0);
    }

    @Test
    public void whenCriteriaMatching_ThenSetClasseCTCMedio() throws IOException {
        Laudo laudo = new Laudo();
        laudo.setId("1");
        laudo.setResponsavel("Lucas");
        laudo.setIndiceSMP(5.2);
        laudo.setpHReferencia(6.5);
        laudo.setCtc(14);
        Diagnostico diagnostico = new Diagnostico();
        adubacaoService.diagnosticoIndiceSMP(laudo, diagnostico);
        Assert.assertEquals("Médio",  diagnostico.getClasseCTC());
    }

    @Test
    public void whenCriteriaMatching_ThenSetClasseCTCAlto() throws IOException {
        Laudo laudo = new Laudo();
        laudo.setId("1");
        laudo.setResponsavel("Lucas");
        laudo.setIndiceSMP(5.2);
        laudo.setpHReferencia(6.5);
        laudo.setCtc(18);
        Diagnostico diagnostico = new Diagnostico();
        adubacaoService.diagnosticoIndiceSMP(laudo, diagnostico);
        Assert.assertEquals("Alto",  diagnostico.getClasseCTC());
    }

    @Test
    public void whenCriteriaMatching_ThenSetClasseCTCMuitoAlto() throws IOException {
        Laudo laudo = new Laudo();
        laudo.setId("1");
        laudo.setResponsavel("Lucas");
        laudo.setIndiceSMP(5.2);
        laudo.setpHReferencia(6.5);
        laudo.setCtc(31);
        Diagnostico diagnostico = new Diagnostico();
        adubacaoService.diagnosticoIndiceSMP(laudo, diagnostico);
        Assert.assertEquals("Muito Alto",  diagnostico.getClasseCTC());
    }

    @Test
    public void whenCriteriaMatching_ThenSetP_classe_2_MB() throws IOException {
        Laudo laudo = new Laudo();
        laudo.setId("1");
        laudo.setResponsavel("Lucas");
        laudo.setFosforoP(3);
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setLaudo(laudo);
        diagnostico.setClasseArgila(2);
        adubacaoService.diagnosticoFertilidade(diagnostico);
        Assert.assertEquals("Muito Baixo",  diagnostico.getClasseFosforoP());
    }

    @Test
    public void whenCriteriaMatching_ThenSetK_class_2_B() throws IOException {
        Laudo laudo = new Laudo();
        laudo.setId("1");
        laudo.setNome("Viera Lucas");
        laudo.setResponsavel("Lucas");
        laudo.setArgila(54);
        laudo.setpH(5.2);
        laudo.setIndiceSMP(5.2);
        laudo.setFosforoP(1.8);
        laudo.setPotassioK(50);
        laudo.setMateriaOrganicaMO(2.9);
        laudo.setAluminioTrocavelAlTroc(1.1);
        laudo.setCalcioTrocavelCaTroc(1.9);
        laudo.setMagnesioTrocavelMgTroc(3.4);
        laudo.setAluminioHidrogenioALplusH(10.9);
        laudo.setCtc(16.9);
        laudo.setSaturacaoCTCBase(33.2);
        laudo.setSaturacaoCTCAl(16.8);
        laudo.setRelacaoCaMg(0.56);
        laudo.setRelacaoCaK(14.82);
        laudo.setRelacaoMgK(26.52);
        laudo.setpHReferencia(6);
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setLaudo(laudo);
        diagnostico = adubacaoService.diagnosticoIndiceSMP(laudo, diagnostico);
        diagnostico = adubacaoService.diagnosticoFertilidade(diagnostico);
        diagnostico.calcularTeorPotassioK();
        diagnostico.calcularQuantidadePotassioK();
        diagnostico.calcularQuantidadeFosforoP();
        Assert.assertEquals("Muito Baixo",  diagnostico.getClasseFosforoP());
        Assert.assertEquals(250,  diagnostico.getQuantidadeFosforoP(), 0);
    }

    @Test
    public void whenCriteriaMatching_ThenSetQuantidade_K_B() throws IOException {
        Laudo laudo = new Laudo();
        laudo.setId("1");
        laudo.setResponsavel("Lucas");
        laudo.setPotassioK(50);
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setLaudo(laudo);
        diagnostico.setClasseCTC("Alto");
        diagnostico = adubacaoService.diagnosticoFertilidade(diagnostico);
        diagnostico.calcularTeorPotassioK();
        diagnostico.calcularQuantidadePotassioK();
        Assert.assertEquals(90,  diagnostico.getQuantidadePotassioK(), 0);
    }
}
