package br.com.caelum.desafio;

import org.junit.Assert;
import org.junit.Test;

public class PalindromoTest {

	@Test
	public void aFraseHeUmPalindromo() {
		Palindromo palindromo = new Palindromo();
		Assert.assertTrue(palindromo.ehPalindromo("Socorram-me subi no onibus em Marrocos"));
	}

	@Test
	public void aFraseNaoHeUmPalindromo() {
		Palindromo p = new Palindromo();
		boolean resultado = p.ehPalindromo("E preciso amar as pessoas como se nao houvesse amanha");
		Assert.assertFalse(resultado);
	}

}
