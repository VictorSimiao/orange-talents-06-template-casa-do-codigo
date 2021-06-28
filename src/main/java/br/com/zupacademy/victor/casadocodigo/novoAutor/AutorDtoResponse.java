package br.com.zupacademy.victor.casadocodigo.novoAutor;

import java.time.format.DateTimeFormatter;

public class AutorDtoResponse {
	
	private Integer id;
	private String nome;
	private String email;
	private String descricao;
	private String dataRegistro;
	
	public AutorDtoResponse(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.dataRegistro = autor.getDataRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	
	
}
