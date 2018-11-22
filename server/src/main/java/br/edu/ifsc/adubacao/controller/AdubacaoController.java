package br.edu.ifsc.adubacao.controller;

import br.edu.ifsc.adubacao.model.Diagnostico;
import br.edu.ifsc.adubacao.model.Laudo;
import br.edu.ifsc.adubacao.repository.IDiagnosticoRepository;
import br.edu.ifsc.adubacao.repository.ILaudoRepository;
import br.edu.ifsc.adubacao.service.AdubacaoService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("api")
public class AdubacaoController {
    @Autowired
    ILaudoRepository laudoRepository;

    @Autowired
    IDiagnosticoRepository diagnosticoRepository;

    AdubacaoService adubacaoService = new AdubacaoService();
    Diagnostico diagnostico = new Diagnostico();

    @GetMapping(path = "adubacoes", produces = "application/JSON")
    public List<Diagnostico> getAll() {
        return diagnosticoRepository.findAll();
    }

    @GetMapping(path = "adubacoes/{id}", produces = "application/JSON")
    public Diagnostico getById(@PathVariable int id) {
        return diagnosticoRepository.findById(id).get();
    }

    @PostMapping(path = "adubacoes", produces = "application/JSON")
    public Diagnostico add(@RequestBody Laudo laudo) throws IOException {
        laudo = laudoRepository.save(laudo);
        diagnostico.setLaudo(laudo);
        diagnostico = adubacaoService.diagnosticoIndiceSMP(laudo, diagnostico);
        return diagnosticoRepository.save(diagnostico);
    }

    @PutMapping(path = "adubacoes/{id}", produces = "application/JSON")
    public Diagnostico updateById(@PathVariable int id, @Valid @RequestBody Diagnostico details) throws IOException {
        diagnostico = diagnosticoRepository.getOne(id);
        diagnostico = details;
        diagnostico = adubacaoService.diagnosticoIndiceSMP(diagnostico.getLaudo(), diagnostico);
        return diagnosticoRepository.save(diagnostico);
    }

    @PatchMapping(path = "adubacoes/{id}", produces = "application/JSON")
    public Diagnostico patchById(@PathVariable int id, @Valid @RequestBody Diagnostico details) throws IOException {
        diagnostico = diagnosticoRepository.getOne(id);
        diagnostico = details;
        diagnostico = adubacaoService.diagnosticoIndiceSMP(diagnostico.getLaudo(), diagnostico);
        return diagnosticoRepository.save(diagnostico);
    }

    @DeleteMapping(path = "adubacoes", produces = "application/JSON")
    public boolean delete(@RequestBody int adubacaoId) {
        diagnosticoRepository.deleteById(adubacaoId);
        return true;
    }
}