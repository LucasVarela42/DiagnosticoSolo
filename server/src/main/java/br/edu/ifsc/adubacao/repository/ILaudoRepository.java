package br.edu.ifsc.adubacao.repository;

import br.edu.ifsc.adubacao.model.Laudo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ILaudoRepository extends MongoRepository<Laudo, String> {
}
