package br.edu.ifsc.adubacao.controller;

import br.edu.ifsc.adubacao.model.Diagnostico;
import br.edu.ifsc.adubacao.model.Laudo;
import br.edu.ifsc.adubacao.repository.IDiagnosticoRepository;
import br.edu.ifsc.adubacao.repository.ILaudoRepository;
import br.edu.ifsc.adubacao.service.AdubacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin("https://diagnostico-solo.herokuapp.com/")
@RestController
@RequestMapping("api")
public class AdubacaoController {
    @Autowired
    ILaudoRepository laudoRepository;

    @Autowired
    IDiagnosticoRepository diagnosticoRepository;

    AdubacaoService adubacaoService = new AdubacaoService();
    Diagnostico diagnostico;

    @GetMapping(path = "adubacoes", produces = "application/JSON")
    public List<Diagnostico> getAll() {
        return diagnosticoRepository.findAll();
    }

    @GetMapping(path = "adubacoes/{id}", produces = "application/JSON")
    public Diagnostico getById(@PathVariable String id) {
        return diagnosticoRepository.findById(id).get();
    }

    @PostMapping(path = "adubacoes", produces = "application/JSON")
    public Diagnostico add(@RequestBody Laudo laudo) throws IOException {
        diagnostico = new Diagnostico();
        laudo = laudoRepository.insert(laudo);
        diagnostico.setLaudo(laudo);
        diagnostico = adubacaoService.diagnosticoIndiceSMP(laudo, diagnostico);
        diagnostico = adubacaoService.diagnosticoFertilidade(diagnostico);
        return diagnosticoRepository.insert(diagnostico);
    }

    @PutMapping(path = "adubacoes/{id}", produces = "application/JSON")
    public Diagnostico updateById(@PathVariable String id, @Valid @RequestBody Diagnostico details) throws IOException {
        diagnostico = new Diagnostico();
        diagnostico = diagnosticoRepository.findById(id).get();
        diagnostico = details;
        diagnostico = adubacaoService.diagnosticoIndiceSMP(diagnostico.getLaudo(), diagnostico);
        diagnostico = adubacaoService.diagnosticoFertilidade(diagnostico);
        return diagnosticoRepository.save(diagnostico);
    }

    @PatchMapping(path = "adubacoes/{id}", produces = "application/JSON")
    public Diagnostico patchById(@PathVariable String id, @Valid @RequestBody Diagnostico details) throws IOException {
        diagnostico = new Diagnostico();
        diagnostico = diagnosticoRepository.findById(id).get();
        diagnostico = details;
        diagnostico = adubacaoService.diagnosticoIndiceSMP(diagnostico.getLaudo(), diagnostico);
        diagnostico = adubacaoService.diagnosticoFertilidade(diagnostico);
        return diagnosticoRepository.save(diagnostico);
    }

    @DeleteMapping(path = "adubacoes", produces = "application/JSON")
    public boolean delete(@RequestBody String adubacaoId) {
        diagnostico = new Diagnostico();
        diagnostico = diagnosticoRepository.findById(adubacaoId).get();
        laudoRepository.deleteById(diagnostico.getLaudo().getId());
        diagnosticoRepository.deleteById(adubacaoId);
        return true;
    }
}
