package br.com.zupacademy.victor.casadocodigo.novoestado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.victor.casadocodigo.novopais.Pais;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Pais pais;

	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	@Deprecated
	public Estado() {

	}
	
	public boolean contemPais(Pais pais) {
		return this.pais.equals(pais);
	}

}
