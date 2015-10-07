package com.algaworks.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.model.Voo;

public class PrecoPassagemGoldTest {

private PrecoPassagemGold precoPassagemGold;
	
	@Before
	public void setup() {
		precoPassagemGold = new PrecoPassagemGold();
	}

	private void assertValorPassagem(double valorEsperado, Voo voo) {
		double valor = precoPassagemGold.calcular(voo);
		
		assertEquals(valorEsperado, valor, 0.001);
	}

	@Test
	public void deveCalcularLimiteMenor() throws Exception {
		Voo voo = new Voo("São Paulo", "Porto Alegre", 400.0);
		
		double valorEsperado = 360.0;
		assertValorPassagem(valorEsperado, voo);
	}

	@Test
	public void deveCalcularLimiteMaior() throws Exception {
		Voo voo = new Voo("São Paulo", "Porto Alegre", 501.0);
		
		double valorEsperado = 425.85;
		assertValorPassagem(valorEsperado, voo);
	}
	
}
