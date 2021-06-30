package br.com.zupacademy.victor.casadocodigo.detalheLivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.victor.casadocodigo.novoLivro.Livro;

public class LivroResponse {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPaginas;
	private String isbn;
	private String dataPublicacao;
	private AutorResponse autor;

	public LivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.autor = new AutorResponse(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public AutorResponse getAutor() {
		return autor;
	}

}
