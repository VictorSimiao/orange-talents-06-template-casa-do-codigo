package br.com.zupacademy.victor.casadocodigo.novoLivro;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivrosController {

	private EntityManager manager;

	public LivrosController(EntityManager manager) {
		this.manager = manager;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroDtoInput input) {
		Livro novoLivro = input.converter(manager);
		manager.persist(novoLivro);
		return ResponseEntity.ok().build();
	}
}
