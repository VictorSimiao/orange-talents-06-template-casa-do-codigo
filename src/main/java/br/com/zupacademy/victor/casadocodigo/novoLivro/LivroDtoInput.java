package br.com.zupacademy.victor.casadocodigo.novoLivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.victor.casadocodigo.novaCategoria.Categoria;
import br.com.zupacademy.victor.casadocodigo.novoAutor.Autor;
import br.com.zupacademy.victor.casadocodigo.validacoes.IsValidId;
import br.com.zupacademy.victor.casadocodigo.validacoes.ValorUnico;

public class LivroDtoInput {
	@NotBlank
	@ValorUnico(nomeDoCampo = "titulo", classeDeDominio = Livro.class)
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;
	
	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	
	@NotNull
	@Min(value = 100)
	private Integer numeroPaginas;
	
	@NotBlank
	@ValorUnico(nomeDoCampo = "isbn", classeDeDominio = Livro.class)
	private String isbn;
	
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@IsValidId(nomeDoCampo = "id", classeDeDominio = Categoria.class)
	private Integer idCategoria;
	
	
	@NotNull
	@IsValidId(nomeDoCampo = "id", classeDeDominio = Autor.class)
	private Integer idAutor;

	public LivroDtoInput(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@NotNull Integer idCategoria, @NotNull Integer idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro converter(EntityManager manager) {
		@NotNull
		Categoria categoria = manager.getReference(Categoria.class, idCategoria);
		@NotNull
		Autor autor = manager.getReference(Autor.class, idAutor);
		return new Livro(titulo,resumo,sumario,preco,numeroPaginas,isbn,categoria,autor);
	}



	
	
	
}
