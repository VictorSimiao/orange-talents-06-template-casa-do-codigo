package br.com.zupacademy.victor.casadocodigo.validacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { ValidaEstadoValidator.class })
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaEstado {

	String message() default "{br.com.zupacademy.beanvalidation.validaestado}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
