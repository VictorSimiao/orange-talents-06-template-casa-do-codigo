package br.com.zupacademy.victor.casadocodigo.novocliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.victor.casadocodigo.novoestado.Estado;
import br.com.zupacademy.victor.casadocodigo.novopais.Pais;
import br.com.zupacademy.victor.casadocodigo.validacoes.IsValidDocumento;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;
	@NotBlank
	@IsValidDocumento
	@Column(nullable = false, unique = true)
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Pais pais;

	@ManyToOne(fetch = FetchType.LAZY)
	private Estado estado;

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank @IsValidDocumento String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep, @NotNull Pais pais) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.pais = pais;
	}
	
	@Deprecated
	public Cliente() {
		
	}

	public boolean adicionaEstado(Estado estado) {
		if (estado.contemPais(pais)) {
			this.estado = estado;
			return true;
		}
		return false;
	}

	public Integer getId() {
		return id;
	}

}
