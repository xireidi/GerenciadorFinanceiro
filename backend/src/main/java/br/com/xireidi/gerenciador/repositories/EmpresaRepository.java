package br.com.xireidi.gerenciador.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.xireidi.gerenciador.models.Empresa;
import br.com.xireidi.gerenciador.models.Pessoa;

@RepositoryRestResource(collectionResourceRel = "empresas", path = "empresas")
public interface EmpresaRepository extends MongoRepository<Empresa, String> {

	Empresa findByCnpj(@Param("cnpj") String cnpj);

	Empresa findByResponsavel(@Param("responsavel") Pessoa responsavel);

}
