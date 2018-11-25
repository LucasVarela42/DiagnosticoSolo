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
}
