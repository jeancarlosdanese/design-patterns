package br.com.danese.empresa.leitor;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;

import br.com.danese.empresa.modelo.Gasto;

public class ImportadorDeGastosTest {

	@Test
	public void deveRetornarUmaListaVaziaSeOArquivoPassadoForVazio() throws ParseException {

		ByteArrayInputStream input = new ByteArrayInputStream(new byte[0]);
		ImportadorDeGastos importador = new ImportadorDeGastos();
		Collection<Gasto> gastos = importador.importa(input);

		assertTrue("A lista não está vazia", gastos.isEmpty());
	}

	@Test
	public void deveRetornarUmGastoDeUmArquivoNoFormatoCorreto() throws ParseException {
		
		String conteudo = "CARTAO010120110000100000123Joao da Silva                 25012970\r\n";

		ByteArrayInputStream input = new ByteArrayInputStream(conteudo.getBytes());
		ImportadorDeGastos importador = new ImportadorDeGastos();
		Collection<Gasto> gastos = importador.importa(input);

		assertEquals("Deve conter um elemento", 1, gastos.size());
	}

}
