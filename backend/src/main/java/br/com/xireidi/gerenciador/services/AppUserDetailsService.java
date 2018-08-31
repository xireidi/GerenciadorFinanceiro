package br.com.xireidi.gerenciador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.xireidi.gerenciador.config.security.AppUserDetails;
import br.com.xireidi.gerenciador.models.Pessoa;
import br.com.xireidi.gerenciador.repositories.PessoaRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	PessoaRepository pessoaRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Pessoa user = pessoaRepository.findByEmail(email);

		if (user != null) {
			return new AppUserDetails(user);
		} else {
			throw new UsernameNotFoundException(email);
		}
	}

}