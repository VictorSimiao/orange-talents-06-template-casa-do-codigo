package br.com.zupacademy.victor.casadocodigo.novoAutor;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	private EntityManager manager;

	public AutoresController(EntityManager manager) {
		this.manager = manager;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDtoResponse> novoAutor(@RequestBody @Valid AutorDtoInput autorInput) {
		Autor novoAutor = autorInput.converter();
		manager.persist(novoAutor);
		return ResponseEntity.ok(new AutorDtoResponse(novoAutor));
	}
}
