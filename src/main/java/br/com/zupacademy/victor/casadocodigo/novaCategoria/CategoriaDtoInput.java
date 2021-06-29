package br.com.zupacademy.victor.casadocodigo.novaCategoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.victor.casadocodigo.validacoes.ValorUnico;

public class CategoriaDtoInput {
	
	@NotBlank
	@ValorUnico(nomeDoCampo = "nome", classeDeDominio = Categoria.class)
	private String nome;

	@JsonCreator(mode = Mode.PROPERTIES)
	public CategoriaDtoInput(@NotBlank String nome) {
		this.nome = nome;
	}
	
	
	public Categoria converter() {
		return new Categoria(nome);
	}

	
	

}
