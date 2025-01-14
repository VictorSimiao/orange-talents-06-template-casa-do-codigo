package br.com.zupacademy.victor.casadocodigo.validacoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidacaoErro {

	private MessageSource messageSource;

	public ValidacaoErro(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<?> handle(MethodArgumentNotValidException exception) {
		List<ErroDeFormularioDto> dtos = new ArrayList<ErroDeFormularioDto>();

		List<FieldError> errosDeCampos = exception.getBindingResult().getFieldErrors();
		if (!errosDeCampos.isEmpty()) {

			List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
			fieldErrors.forEach(erro -> {
				String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
				ErroDeFormularioDto erroDto = new ErroDeFormularioDto(erro.getField(), mensagem);
				dtos.add(erroDto);
			});
			return dtos;
		}
		return exception.getBindingResult().getGlobalErrors();
	}
}
