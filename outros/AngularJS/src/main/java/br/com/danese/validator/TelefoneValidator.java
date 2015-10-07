package br.com.danese.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, String> {

	private Pattern patternTelefone = Pattern.compile(new String("[0-9]{10}"));
	private Pattern patternTelefoneNonoDig = Pattern.compile("[0-9]{11}");
	
	@Override
	public void initialize(Telefone constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return isValid(value);
	}
	
	public boolean isValid(String value) {
		if (value != null) {
			String telefone = value.toString().replaceAll("[()-]", "");
			if(telefone.length()==10) { 
				Matcher m = patternTelefone.matcher(telefone);
				return m.matches();
			} else if(telefone.length()==11) {
				Matcher m = patternTelefoneNonoDig.matcher(telefone);
				return m.matches();
			}
			
		}
		return false;
	}

}