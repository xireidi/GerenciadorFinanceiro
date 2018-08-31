package br.com.xireidi.gerenciador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.xireidi.gerenciador.models.Pessoa;
import br.com.xireidi.gerenciador.repositories.PessoaRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;


	public Pessoa getAuthenticatedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Pessoa pessoa = pessoaRepository.findByEmail(auth.getName());

		if(pessoa == null) {
			log.info("Não foi possível encontrar o usuário logado.");
		}
		
		log.debug("Usuário "+pessoa.getNome()+ " está logado.");
		
		return pessoa;
	}
}
