package br.com.danese.strategy.imposto.templateMethod;

import br.com.danese.strategy.imposto.Imposto;
import br.com.danese.strategy.imposto.Orcamento;

public abstract class TemplateDeImpostoCondicional extends Imposto {

	public TemplateDeImpostoCondicional() {
	}

	public TemplateDeImpostoCondicional(Imposto outroImposto) {
		super(outroImposto);
	}
	
	@Override
	public final double calcula(Orcamento orcamento) {
		if (deveUsarMaximaTaxacao(orcamento)) {
			return maximaTaxacao(orcamento) + calculaOutroImposto(orcamento);
		} else {
			return minimaTaxacao(orcamento) + calculaOutroImposto(orcamento);
		}
	}

	protected abstract double minimaTaxacao(Orcamento orcamento);

	protected abstract double maximaTaxacao(Orcamento orcamento);

	protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

}
