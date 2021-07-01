package br.com.zupacademy.victor.casadocodigo.novopais;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisesController {

	private EntityManager manager;

	public PaisesController(EntityManager manager) {
		this.manager = manager;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastroPais(@RequestBody @Valid PaisDtoInput input) {
		Pais novoPais = input.converter();
		manager.persist(novoPais);
		return ResponseEntity.ok().build();
	}

}
