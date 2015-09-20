package br.com.danese.strategy.imposto.templateMethod;

import br.com.danese.strategy.imposto.Imposto;
import br.com.danese.strategy.imposto.Orcamento;

public class ICPP extends TemplateDeImpostoCondicional {
	
	public ICPP() {
	}

	public ICPP(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500;
	}

	/*
	 * @Override public double calcula(Orcamento orcamento) {
	 * if(orcamento.getValor() > 500) { return orcamento.getValor() * 0.07; }
	 * else { return orcamento.getValor() * 0.05; } }
	 */

}
