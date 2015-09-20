package br.com.caelum.leilao.servico;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.dominio.builder.CriadorDeLeilao;

public class AvaliadorTest {

	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;

	@BeforeClass
	public static void testandoBeforeClass() {
//		System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
//		System.out.println("after class");
	}

	@Before
	public void setUp() {
		this.leiloeiro = new Avaliador();
		joao = new Usuario("Joao");
		jose = new Usuario("José");
		maria = new Usuario("Maria");

		// System.out.println("inicializando teste!");
	}

	@After
	public void finaliza() {
		// System.out.println("fim");
	}

	/*@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();

		leiloeiro.avalia(leilao);
	}*/

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// cenario: 3 lances em ordem crescente
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 300.0).lance(jose, 400.0)
				.lance(maria, 250.0).constroi();

		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
//		double maiorEsperado = 400;
//		double menorEsperado = 250;
		double mediaEsperado = 316.6667;

//		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
//		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		assertEquals(mediaEsperado, leiloeiro.getMediaDosLances(), 0.0001);
		
		assertThat(leiloeiro.getMenorLance(), equalTo(250.0));
        assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 200.0).constroi();

		leiloeiro.avalia(leilao);

		assertEquals(200, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(200, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLeilaoComLancesAleatorios() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 800.0).lance(jose, 300.0)
				.lance(maria, 2000.0).lance(joao, 1200.0).lance(jose, 500.0).lance(maria, 600.0).lance(joao, 200.0)
				.lance(jose, 2500.0).lance(maria, 2400.0).lance(maria, 900.0).constroi();

		leiloeiro.avalia(leilao);

		assertEquals(2500, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(200, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 100.0).lance(jose, 200.0)
				.lance(maria, 300.0).lance(jose, 400.0).constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(200, maiores.get(2).getValor(), 0.00001);
	}

	@Test
	public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 100.0).lance(jose, 200.0)
				.constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(2, maiores.size());
		assertEquals(200, maiores.get(0).getValor(), 0.00001);
		assertEquals(100, maiores.get(1).getValor(), 0.00001);
	}

	@Test
	public void deveDevolverListaVaziaCasoNaoHajaLances() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(0, maiores.size());
	}

}
