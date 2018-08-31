package br.com.xireidi.gerenciador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xireidi.gerenciador.models.Empresa;
import br.com.xireidi.gerenciador.models.Pessoa;
import br.com.xireidi.gerenciador.repositories.EmpresaRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EmpresaService {
	
	@Autowired
	EmpresaRepository empresaRepository;

	public Empresa findEmpresaByPessoa(Pessoa pessoa) {
		Empresa empresa = empresaRepository.findByResponsavel(pessoa);
		
		if(empresa == null) {
			log.info("Não foi possível encontrar a empresa pela pessoa: "+pessoa.getNome()+ "["+pessoa.getId()+"]");
		}
		
		return empresa;
	}
}
