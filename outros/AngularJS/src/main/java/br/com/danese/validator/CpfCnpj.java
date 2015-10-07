package br.com.danese.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CpfCnpjValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {
   
	String message() default "Documento inválido";

	boolean formatted() default false;
	
	boolean ignoreRepeated() default false;
    
	Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}