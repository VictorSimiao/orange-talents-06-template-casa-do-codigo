package br.com.zupacademy.victor.casadocodigo.novoestado;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadosController {

	private EntityManager manager;

	public EstadosController(EntityManager manager) {
		this.manager = manager;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastroEstado(@RequestBody @Valid EstadoDtoInput input) {
		Estado novoEstado = input.converter(manager);
		manager.persist(novoEstado);
		return ResponseEntity.ok().build();
	}
}
