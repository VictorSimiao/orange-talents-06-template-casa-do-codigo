package br.com.zupacademy.victor.casadocodigo.detalheLivro;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.victor.casadocodigo.novoLivro.Livro;

public class LivroDetalheResponse {

	private Integer id;
	private String titulo;

	public LivroDetalheResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<LivroDetalheResponse> converteParaDto(List<Livro> livros) {
		return livros.stream().map(LivroDetalheResponse::new).collect(Collectors.toList());
	}
}
