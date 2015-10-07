package com.algaworks.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.model.Passageiro;
import com.algaworks.model.TipoPassageiro;
import com.algaworks.model.Voo;

public class PrecoPassagemServiceTest {

	private PrecoPassagemService precoPassagemService;
	
	@Before
	public void setup() {
		precoPassagemService = new PrecoPassagemService();
	}

	private void assertValorPassagem(Passageiro passageiro, Voo voo, double valorEsperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(valorEsperado, valor, 0.0001);
	}
	
	@Test
	public void deveCalcularPrecoParaPassageiroGold_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		
		assertValorPassagem(passageiro, voo, 90.0);
	}

	@Test
	public void deveCalcularPrecoParaPassageiroGold_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);
		
		assertValorPassagem(passageiro, voo, 510.0);
	}
	
	@Test
	public void deveCalcularPrecoParaPassageiroSilver_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		
		assertValorPassagem(passageiro, voo, 94.0);
	}
	
	@Test
	public void deveCalcularPrecoParaPassageiroSilver_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
		
		assertValorPassagem(passageiro, voo, 720.0);
	}
	
	
}
