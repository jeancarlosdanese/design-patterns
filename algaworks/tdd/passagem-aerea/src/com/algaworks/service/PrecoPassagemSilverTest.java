package com.algaworks.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.model.Voo;

public class PrecoPassagemSilverTest {

	private PrecoPassagemSilver precoPassagemSilver;

	@Before
	public void setup() {
		precoPassagemSilver = new PrecoPassagemSilver();
	}

	private void assertValorPassagem(double valorEsperado, Voo voo) {
		double valor = precoPassagemSilver.calcular(voo);
		
		assertEquals(valorEsperado, valor, 0.001);
	}
	
	@Test
	public void testCalcularLimiteMenor() {
		Voo voo = new Voo("São Paulo", "Curitiba", 699.0);
		
		double valorEsperado = 657.06;
		
		assertValorPassagem(valorEsperado, voo);
	}

	@Test
	public void testCalcularLimiteMaior() {
		Voo voo = new Voo("São Paulo", "Curitiba", 700.01);
		
		double valorEsperado = 630.009;
		
		assertValorPassagem(valorEsperado, voo);
	}
	
}
