package br.com.xireidi.gerenciador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.xireidi.gerenciador.models.Empresa;
import br.com.xireidi.gerenciador.models.Pessoa;
import br.com.xireidi.gerenciador.repositories.EmpresaRepository;
import br.com.xireidi.gerenciador.repositories.PessoaRepository;
import lombok.extern.log4j.Log4j2;

@Component
public class InitialLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.createAccount();
	}

	public void createAccount() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		Pessoa pessoa = new Pessoa();
		pessoa.setAtiva(true);
		pessoa.setNome("Maicon Andrey Gorges");
		pessoa.setCep("046.066.739-40");
		pessoa.setTelefoneContatoCelular("47999119011");
		pessoa.setEmail("allysson@primeinternacional.com.br");
		pessoa.setSenha(passwordEncoder.encode("admin"));

		Pessoa pessoaDB = pessoaRepository.findByCpf(pessoa.getCpf());

		if (pessoaDB == null)
			pessoa = pessoaRepository.insert(pessoa);
		else
			pessoa = pessoaDB;

		Empresa empresa = new Empresa();
		empresa.setFantasia("PRIME INTERNACIONAL");
		empresa.setRazaoSocial("PRIME INTERNACIONAL COMERCIO EXTERIOR EIRELI");
		empresa.setTelefoneContatoFixo("4730451688");
		empresa.setTelefoneContatoCelular("47999999999");
		empresa.setEmail("allysson@primeinternacional.com.br");
		empresa.setResponsavel(pessoa);
		empresa.setTipoEndereco("Comercial");
		empresa.setCep("");
		empresa.setLogradouro("");
		empresa.setNumero("");
		empresa.setBairro("");
		empresa.setComplemento("");
		empresa.setPontoReferencia("");
		empresa.setCidade("");
		empresa.setUf("");

		Empresa empresaDB = empresaRepository.findByCnpj(empresa.getCnpj());

		if (empresaDB == null)
			empresa = empresaRepository.insert(empresa);
		else
			empresa = empresaDB;

	}

}
