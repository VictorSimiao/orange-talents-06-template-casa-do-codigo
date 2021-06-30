package br.com.zupacademy.victor.casadocodigo.detalheLivro;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.victor.casadocodigo.novoLivro.Livro;

@RestController
@RequestMapping("/livros")
public class LivrosDetalheController {

	private EntityManager manager;

	public LivrosDetalheController(EntityManager manager) {
		this.manager = manager;
	}

	@GetMapping
	public ResponseEntity<List<LivroDetalheResponse>> listaLivro() {
		List<Livro> livros = manager.createQuery("select l from Livro l").getResultList();
		List<LivroDetalheResponse> livrosResponse = LivroDetalheResponse.converteParaDto(livros);
		return ResponseEntity.ok(livrosResponse);
	}

}
