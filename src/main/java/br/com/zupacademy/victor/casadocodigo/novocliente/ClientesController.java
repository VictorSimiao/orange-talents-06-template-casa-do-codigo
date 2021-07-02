package br.com.zupacademy.victor.casadocodigo.novocliente;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	private EntityManager manager;

	public ClientesController(EntityManager manager) {
		this.manager = manager;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDtoResponse> cadastroCliente(@RequestBody @Valid ClienteDtoInput input) {
		Cliente novoCliente = input.converter(manager);
		manager.persist(novoCliente);
		return ResponseEntity.ok(new ClienteDtoResponse(novoCliente));
	}

}
