package br.com.danese;

import br.com.danese.strategy.imposto.ICMS;
import br.com.danese.strategy.imposto.Imposto;
import br.com.danese.strategy.imposto.ImpostoMuitoAlto;
import br.com.danese.strategy.imposto.Orcamento;

public class TesteDeImpostosComplexos {

	public static void main(String[] args) {
		Imposto iss = new ImpostoMuitoAlto(new ICMS() );
		
		Orcamento orcamento = new Orcamento(500);
		
		double valor = iss.calcula(orcamento);
		
		System.out.println(valor);
	}
	
}
