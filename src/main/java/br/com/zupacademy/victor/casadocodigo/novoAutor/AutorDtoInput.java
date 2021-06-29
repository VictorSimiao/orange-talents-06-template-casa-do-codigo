package br.com.zupacademy.victor.casadocodigo.novoAutor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.victor.casadocodigo.validacoes.ValorUnico;

public class AutorDtoInput {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@ValorUnico(nomeDoCampo ="email",classeDeDominio = Autor.class)
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorDtoInput(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor converter() {
		return new Autor(nome,email,descricao);
	}

	

}
