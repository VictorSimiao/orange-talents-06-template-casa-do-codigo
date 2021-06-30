package br.com.zupacademy.victor.casadocodigo.detalheLivro;

import br.com.zupacademy.victor.casadocodigo.novoAutor.Autor;

public class AutorResponse {

	private String nome;
	private String descricao;

	public AutorResponse(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}
