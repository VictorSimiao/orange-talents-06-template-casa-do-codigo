package br.com.zupacademy.victor.casadocodigo.validacoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class IsValidIdValidator implements ConstraintValidator<IsValidId, Object> {
	private String campo;
	private Class<?> klass;
	private EntityManager manager;

	public IsValidIdValidator(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void initialize(IsValidId valorParametro) {
		campo = valorParametro.nomeDoCampo();
		klass = valorParametro.classeDeDominio();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager
				.createQuery("select 1 from " + klass.getName() + " where " + campo + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();

		Assert.state(list.size() <= 1,
				"Foi encontrado mais de um " + klass + " com o atributo " + campo + " = " + value);
		return !list.isEmpty();
	}
}
