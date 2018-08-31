package br.com.xireidi.gerenciador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.xireidi.gerenciador.models.Pessoa;
import br.com.xireidi.gerenciador.repositories.PessoaRepository;

@Service
public class CredentialsSecurityService {

	@Autowired
	PessoaRepository pessoaRepository;

	private Pessoa authorizedUser;

	public Pessoa authorize(Pessoa user) {
		this.authorizedUser = null;

		if (user != null) {
			if (user.getEmail() != null && user.getSenha() != null) {
				this.authorizedUser = pessoaRepository.findByEmail(user.getEmail());

				if (this.authorizedUser != null) {
					if (new BCryptPasswordEncoder().matches(user.getSenha(), this.authorizedUser.getSenha())) return this.authorizedUser;
				}

			}
		}

		return null;
	}

}