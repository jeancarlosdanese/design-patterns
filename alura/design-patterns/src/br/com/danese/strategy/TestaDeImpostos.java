package br.com.danese.strategy;

import br.com.danese.strategy.imposto.CalculadorDeImposto;
import br.com.danese.strategy.imposto.ICCC;
import br.com.danese.strategy.imposto.ICMS;
import br.com.danese.strategy.imposto.ISS;
import br.com.danese.strategy.imposto.Imposto;
import br.com.danese.strategy.imposto.Orcamento;

public class TestaDeImpostos {
	public static void main(String[] args) {
		Imposto icsm = new ICMS();
		Imposto iss = new ISS();
		Imposto iccc = new ICCC();
		
		Orcamento orcamento = new Orcamento(3001.0);
		
		CalculadorDeImposto calculador = new CalculadorDeImposto();
		
		calculador.realizaCalculo(orcamento, icsm);
		calculador.realizaCalculo(orcamento, iss);
		calculador.realizaCalculo(orcamento, iccc);
		
	}
}
