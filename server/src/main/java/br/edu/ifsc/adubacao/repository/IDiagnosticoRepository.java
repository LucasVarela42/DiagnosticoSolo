package br.edu.ifsc.adubacao.repository;

import br.edu.ifsc.adubacao.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IDiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
}
