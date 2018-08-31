package br.com.xireidi.gerenciador.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.xireidi.gerenciador.models.Empresa;
import br.com.xireidi.gerenciador.models.Pessoa;
import br.com.xireidi.gerenciador.services.EmpresaService;
import br.com.xireidi.gerenciador.services.PessoaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/credentials")
public class CredentialsController {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	EmpresaService empresaService;

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ResponseEntity<HashMap<String, Object>> getInfo() {
		HashMap<String, Object> info = new HashMap<>();
		
		Pessoa p = pessoaService.getAuthenticatedUser();
		Empresa e = empresaService.findEmpresaByPessoa(p);
		
		if(p != null) info.put("pessoa",p);
		if(e != null) info.put("empresa",e);
		
		return new ResponseEntity<>(info, HttpStatus.ACCEPTED);
	}

}
