package br.com.zupacademy.victor.casadocodigo.novaCategoria;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

	private EntityManager manager;

	public CategoriasController(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDtoResponse> cadastroCategoria(@RequestBody @Valid CategoriaDtoInput input) {
		Categoria novaCategoria = input.converter();
		manager.persist(novaCategoria);
		return ResponseEntity.ok(new CategoriaDtoResponse(novaCategoria));
	}

}
