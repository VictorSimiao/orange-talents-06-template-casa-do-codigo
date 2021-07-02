package br.com.zupacademy.victor.casadocodigo.novocliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.victor.casadocodigo.novoestado.Estado;
import br.com.zupacademy.victor.casadocodigo.novopais.Pais;
import br.com.zupacademy.victor.casadocodigo.validacoes.IsValidDocumento;
import br.com.zupacademy.victor.casadocodigo.validacoes.IsValidId;
import br.com.zupacademy.victor.casadocodigo.validacoes.ValorUnico;


public class ClienteDtoInput {
	@NotBlank
	@Email
	@ValorUnico(nomeDoCampo = "email", classeDeDominio = Cliente.class)
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@IsValidDocumento
	@ValorUnico(nomeDoCampo = "documento", classeDeDominio = Cliente.class)
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
	@IsValidId(nomeDoCampo = "id", classeDeDominio = Pais.class)
	private Integer idPais;

	private Integer idEstado;

	public ClienteDtoInput(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank @IsValidDocumento String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, Integer idEstado, @NotBlank String telefone, @NotBlank String cep,
			@NotNull Integer idPais) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
		this.idPais = idPais;
	}

	public Cliente converter(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep,
				pais);
		if (idEstado != null) {
			Estado estado = manager.find(Estado.class, idEstado);
			Assert.isTrue(cliente.adicionaEstado(estado), "O estado informado não pertence ao País");
		}
		return cliente;
	}

}
