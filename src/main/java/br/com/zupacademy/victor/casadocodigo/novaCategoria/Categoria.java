package br.com.zupacademy.victor.casadocodigo.novaCategoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private @NotBlank String nome;
	
	@Deprecated
	public Categoria() {
		
	}

	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	

}
