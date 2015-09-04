package br.com.danese.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.stella.bean.validation.logic.AnnotationMessageProducer;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {

	private CPFValidator stellaCpfValidator;
	private CNPJValidator stellaCnpjValidator;

	@Override
	public void initialize(CpfCnpj cpfCnpj) {
		AnnotationMessageProducer messageProducer = new AnnotationMessageProducer(cpfCnpj);
		
		stellaCpfValidator = new CPFValidator(messageProducer, cpfCnpj.formatted(),cpfCnpj.ignoreRepeated());
		stellaCnpjValidator = new CNPJValidator(messageProducer, cpfCnpj.formatted());
	}

	@Override
	public boolean isValid(String cpfCnpj, ConstraintValidatorContext context) {
		
		if (cpfCnpj != null) {
			cpfCnpj = cpfCnpj.replaceAll("\\.", "").replaceAll("-", "").replaceAll("/", "");
			if (cpfCnpj.trim().length() == 0) {
				return true;
			} else if(cpfCnpj.length()==11) {
				return stellaCpfValidator.invalidMessagesFor(cpfCnpj).isEmpty();
			} else if(cpfCnpj.length()==14) {
				return stellaCnpjValidator.invalidMessagesFor(cpfCnpj).isEmpty();
			} 
		} 

		return true;
		
	}
	
	public boolean isValid(String cpfCnpj) {
		
		if (cpfCnpj != null) {
			cpfCnpj = cpfCnpj.replaceAll("\\.", "").replaceAll("-", "").replaceAll("/", "");
			if (cpfCnpj.trim().length() == 0) {
				return true;
			} else if(cpfCnpj.length()==11) {
				return stellaCpfValidator.invalidMessagesFor(cpfCnpj).isEmpty();
			} else if(cpfCnpj.length()==14) {
				return stellaCnpjValidator.invalidMessagesFor(cpfCnpj).isEmpty();
			} 
		} 

		return true;
		
	}
	
}