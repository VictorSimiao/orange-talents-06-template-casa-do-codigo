package br.com.zupacademy.victor.casadocodigo.validacoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.victor.casadocodigo.novoestado.EstadoDtoInput;
import br.com.zupacademy.victor.casadocodigo.novopais.Pais;

public class ValidaEstadoValidator implements ConstraintValidator<ValidaEstado, EstadoDtoInput> {

	private EntityManager manager;

	public ValidaEstadoValidator(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void initialize(ValidaEstado validaEstado) {
	}

	@Override
	public boolean isValid(EstadoDtoInput estadoDtoInput, ConstraintValidatorContext context) {

		String nomeEstado = estadoDtoInput.getNome();
		Pais pais = manager.find(Pais.class, estadoDtoInput.getIdPais());

		Query query = manager.createQuery("SELECT e FROM Estado e WHERE e.nome = :nome AND e.pais = :id_pais");
		query.setParameter("nome", nomeEstado).setParameter("id_pais", pais);

		List<?> list = query.getResultList();
		return list.isEmpty();
	}

}
