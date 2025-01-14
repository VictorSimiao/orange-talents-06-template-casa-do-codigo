package br.com.zupacademy.victor.casadocodigo.novoLivro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.victor.casadocodigo.novaCategoria.Categoria;
import br.com.zupacademy.victor.casadocodigo.novoAutor.Autor;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Column(nullable = false, unique = true)
	private String titulo;
	@NotBlank
	@Size(max = 500)
	@Column(nullable = false, length = 500)
	private String resumo;
	@NotBlank
	@Column(nullable = false)
	private String sumario;
	@NotNull
	@Min(20)
	@Column(nullable = false)
	private BigDecimal preco;
	@NotNull
	@Min(100)
	@Column(nullable = false)
	private Integer numeroPaginas;
	@NotBlank
	@Column(nullable = false, unique = true)
	private String isbn;
	@NotNull
	@Column(nullable = false)
	private LocalDate dataPublicacao;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Autor autor;

	@Deprecated
	public Livro() {

	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@NotNull LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Integer getId() {
		return id;
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

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

}
