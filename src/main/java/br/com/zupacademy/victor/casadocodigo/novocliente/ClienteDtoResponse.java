package br.com.zupacademy.victor.casadocodigo.novocliente;

public class ClienteDtoResponse {

	private Integer id;

	public ClienteDtoResponse(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Integer getId() {
		return id;
	}

}
