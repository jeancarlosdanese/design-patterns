package br.com.danese.strategy;

import br.com.danese.strategy.investimento.Conta;
import br.com.danese.strategy.investimento.Investimento;
import br.com.danese.strategy.investimento.InvestimentoArrojado;
import br.com.danese.strategy.investimento.InvestimentoConservador;
import br.com.danese.strategy.investimento.InvestimentoModerado;
import br.com.danese.strategy.investimento.RealizadorDeInvestimentos;

public class TestaInvestimento {
	
	public static void main(String[] args) {
		Investimento conservador = new InvestimentoConservador();
		Investimento moderado = new InvestimentoModerado();
		Investimento arrojado = new InvestimentoArrojado();
		
		RealizadorDeInvestimentos realizadorDeInvestimentos = new RealizadorDeInvestimentos();
		
		Conta c1 = new Conta();
		c1.deposita(1000.0);
		realizadorDeInvestimentos.realiza(c1, conservador);

		Conta c2 = new Conta();
		c2.deposita(1000.0);
		realizadorDeInvestimentos.realiza(c2, moderado);
		
		Conta c3 = new Conta();
		c3.deposita(1000.0);
		realizadorDeInvestimentos.realiza(c3, arrojado);
	}

}
