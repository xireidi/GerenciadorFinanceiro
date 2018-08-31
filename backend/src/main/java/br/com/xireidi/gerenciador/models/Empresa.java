package br.com.xireidi.gerenciador.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Empresa {

	@Id
	private String id;
	private String fantasia;
	private String razaoSocial;
	@Indexed(name = "cnpj", unique = true)
	private String cnpj;
	private String telefoneContatoFixo;
	private String telefoneContatoCelular;

	@TextIndexed
	private String email;

	@DBRef
	private Pessoa responsavel;

	private String tipoEndereco;
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private String pontoReferencia;
	private String cidade;
	private String uf;

}
