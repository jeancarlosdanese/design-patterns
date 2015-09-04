package br.com.danese.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<Cep, String> {

//	private Pattern pattern = Pattern.compile("[0-9]{5}-[0-9]{3}");
	private Pattern pattern = Pattern.compile("[0-9]{8}");
	
	@Override
	public void initialize(Cep constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Matcher m = pattern.matcher(value);
		return m.matches();
	}
	
	public boolean isValid(String value) {
		Matcher m = pattern.matcher(value.replace("-", ""));
		return m.matches();
	}

}