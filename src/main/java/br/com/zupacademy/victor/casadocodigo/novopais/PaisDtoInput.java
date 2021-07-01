package br.com.zupacademy.victor.casadocodigo.novopais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.victor.casadocodigo.validacoes.ValorUnico;

public class PaisDtoInput {
	
	@NotBlank
	@ValorUnico(nomeDoCampo = "nome", classeDeDominio = Pais.class)
	private String nome;
 
	@JsonCreator(mode = Mode.PROPERTIES)
	public PaisDtoInput(@NotBlank String nome) {
		this.nome = nome;
	}

	public Pais converter() {
		return new Pais(nome);
	}

	
	
	
	
}
