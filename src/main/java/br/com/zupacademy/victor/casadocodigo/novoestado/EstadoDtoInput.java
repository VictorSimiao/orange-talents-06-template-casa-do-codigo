package br.com.zupacademy.victor.casadocodigo.novoestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.victor.casadocodigo.novopais.Pais;
import br.com.zupacademy.victor.casadocodigo.validacoes.IsValidId;
import br.com.zupacademy.victor.casadocodigo.validacoes.ValidaEstado;

@ValidaEstado
public class EstadoDtoInput {

	@NotBlank
	private String nome;

	@NotNull
	@IsValidId(nomeDoCampo = "id", classeDeDominio = Pais.class)
	private Integer idPais;

	public EstadoDtoInput(@NotBlank String nome, @NotNull Integer idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}
	
	public Integer getIdPais() {
		return idPais;
	}
	
	public String getNome() {
		return nome;
	}

	public Estado converter(EntityManager manager) {
		Pais pais = manager.getReference(Pais.class, idPais);
		return new Estado(nome, pais);
	}

}
