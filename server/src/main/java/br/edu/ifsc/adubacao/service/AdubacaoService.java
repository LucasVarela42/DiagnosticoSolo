package br.edu.ifsc.adubacao.service;

import br.edu.ifsc.adubacao.config.DroolsBeanFactory;
import br.edu.ifsc.adubacao.model.Diagnostico;
import br.edu.ifsc.adubacao.model.Laudo;
import org.kie.api.runtime.KieSession;

import java.io.IOException;

public class AdubacaoService {

    KieSession kieSession= new DroolsBeanFactory().getKieSession();

    public Diagnostico diagnosticoIndiceSMP(Laudo laudo, Diagnostico diagnostico) throws IOException {
        kieSession.insert(laudo);
        kieSession.setGlobal("diagnostico",diagnostico);
        kieSession.fireAllRules();
        return diagnostico;
    }

    public Diagnostico diagnosticoFertilidade(Diagnostico diagnostico) throws IOException {
        kieSession.insert(diagnostico);
        kieSession.setGlobal("diagnostico",diagnostico);
        kieSession.fireAllRules();
        return diagnostico;
    }
}
