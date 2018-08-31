package br.com.xireidi.gerenciador.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Document
public class Pessoa {

	@Id
	private String id;
	private Boolean ativa;
	private String nome;
	@Indexed(name = "cpf", unique = true)
	private String cpf;
	private String rg;
	private Character sexo;
	private LocalDate dataNascimento;
	private String telefoneContatoFixo;
	private String telefoneContatoCelular;
	@TextIndexed
	private String email;
	
	@JsonIgnore
	private String senha;
	
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