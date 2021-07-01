package br.com.zupacademy.victor.casadocodigo.novopais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, unique = true)
	private @NotBlank String nome;

	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}
	
	@Deprecated
	public Pais() {
	
	}

}