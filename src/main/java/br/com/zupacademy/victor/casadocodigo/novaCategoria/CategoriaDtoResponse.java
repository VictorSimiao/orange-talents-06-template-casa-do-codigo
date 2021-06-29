package br.com.zupacademy.victor.casadocodigo.novaCategoria;

public class CategoriaDtoResponse {

	private Integer id;
	private String nome;

	public CategoriaDtoResponse(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
