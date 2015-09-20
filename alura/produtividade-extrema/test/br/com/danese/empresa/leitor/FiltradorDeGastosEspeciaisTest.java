package br.com.danese.empresa.leitor;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import br.com.danese.empresa.modelo.Funcionario;
import br.com.danese.empresa.modelo.Gasto;

public class FiltradorDeGastosEspeciaisTest {

	@Test
	public void soDevolveGastosComValorMaiorQueOLimite() {
		
		Funcionario funcionario = new Funcionario("Mario", 123, new GregorianCalendar(1876, 3, 23));
		Gasto g1 = new Gasto(25.0, "taxi", funcionario, Calendar.getInstance());
		Gasto g2 = new Gasto(150.0, "almoço", funcionario, Calendar.getInstance());
		Gasto g3 = new Gasto(22.0, "hotel", funcionario, Calendar.getInstance());
		
		List<Gasto> gastos = Arrays.asList(g1, g2, g3);
		
		FiltradorDeGastosEspeciais filtrador = new FiltradorDeGastosEspeciais(25.0);
		List<Gasto> gastosGrandes = filtrador.filtraGastosGrandes(gastos);
		
		assertEquals(2, gastosGrandes.size());
		assertEquals(25.0, gastosGrandes.get(0).getValor(), 0.00001);
		assertEquals(150.0, gastosGrandes.get(1).getValor(), 0.00001);
		
	}

}
