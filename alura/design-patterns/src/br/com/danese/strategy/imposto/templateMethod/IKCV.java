package br.com.danese.strategy.imposto.templateMethod;

import br.com.danese.strategy.imposto.Imposto;
import br.com.danese.strategy.imposto.Orcamento;

public class IKCV extends TemplateDeImpostoCondicional {

	public IKCV() {
	}

	public IKCV(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemMaioQue100ReaisNoOrcamento(orcamento);
	}

	private boolean temItemMaioQue100ReaisNoOrcamento(Orcamento orcamento) {
		return orcamento.getItens().stream().filter(i -> i.getValor() > 100).findAny().isPresent();
	}

	/*
	 * @Override public double calcula(Orcamento orcamento) {
	 * if(orcamento.getValor() > 500 &&
	 * temItemMaioQue100ReaisNoOrcamento(orcamento)) { return
	 * orcamento.getValor() * 0.10; } else { return orcamento.getValor() * 0.06;
	 * } }
	 */
}
