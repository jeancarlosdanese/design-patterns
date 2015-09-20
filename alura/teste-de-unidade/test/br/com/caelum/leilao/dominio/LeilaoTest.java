package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeilaoTest {

	@Test
	public void recebeProposta() {
		Leilao leilao = new Leilao("Notebook Dell 15\"");
		leilao.propoe(new Lance(new Usuario("Luiz"), 200));
		
		assertEquals(200, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(1, leilao.getLances().size());
	}
	
	@Test
	public void naoDeveAceitar2LancesSeguidosDoMesmoUsusario() {
		Leilao leilao = new Leilao("Notebook Dell 15\"");

		leilao.propoe(new Lance(new Usuario("Luiz"), 200));
		leilao.propoe(new Lance(new Usuario("Luiz"), 300));
		
		assertEquals(200, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(1, leilao.getLances().size());
	}

	@Test
	public void naoDeveAceitarMaisDe5LancesDoMesmoUsusario() {
		Leilao leilao = new Leilao("Notebook Dell 15\"");

		Usuario luiz = new Usuario("Luiz");
		Usuario mario = new Usuario("Mario");
		
		leilao.propoe(new Lance(luiz, 100));
		leilao.propoe(new Lance(mario, 200));
		leilao.propoe(new Lance(luiz, 350));
		leilao.propoe(new Lance(mario, 300));
		leilao.propoe(new Lance(luiz, 450));
		leilao.propoe(new Lance(mario, 400));
		leilao.propoe(new Lance(luiz, 550));
		leilao.propoe(new Lance(mario, 500));
		leilao.propoe(new Lance(luiz, 650));
		leilao.propoe(new Lance(mario, 600));
		leilao.propoe(new Lance(luiz, 750));

		assertEquals(10, leilao.getLances().size());
		int index = leilao.getLances().size() - 1;
		Lance ultimoLance = leilao.getLances().get(index );
		assertEquals(600, ultimoLance .getValor(), 0.00001);
	}
	
	@Test
    public void deveDobrarOUltimoLanceDado() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");
        Usuario billGates = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(billGates, 3000));
        leilao.dobraLance(steveJobs);

        assertEquals(4000, leilao.getLances().get(2).getValor(), 0.00001);
    }
	
	@Test
    public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");

        leilao.dobraLance(steveJobs);

        assertEquals(0, leilao.getLances().size());
    }
	
}
