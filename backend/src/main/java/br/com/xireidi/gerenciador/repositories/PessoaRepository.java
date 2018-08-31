package br.com.xireidi.gerenciador.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.xireidi.gerenciador.models.Pessoa;

@RepositoryRestResource(collectionResourceRel = "pessoas", path = "pessoas")
public interface PessoaRepository extends MongoRepository<Pessoa, String> {

	Pessoa findByCpf(@Param("cpf") String cpf);

	Pessoa findByEmail(@Param("email") String email);

}
