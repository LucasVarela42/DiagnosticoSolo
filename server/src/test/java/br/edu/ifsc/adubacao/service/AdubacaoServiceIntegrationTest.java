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
    public void whenCriteriaMatching_ThenSetQuantidadceCalcario() throws IOException {
        Laudo laudo = new Laudo();
        laudo.setId(1);
        laudo.setResponsavel("Lucas");
        laudo.setIndiceSMP(5.2);
        laudo.setpHReferencia(6.5);
        Diagnostico diagnostico = new Diagnostico();
        adubacaoService.diagnosticoIndiceSMP(laudo, diagnostico);
        Assert.assertEquals(18.83, diagnostico.getQuantidadeCalcario(), 0);
    }
}
