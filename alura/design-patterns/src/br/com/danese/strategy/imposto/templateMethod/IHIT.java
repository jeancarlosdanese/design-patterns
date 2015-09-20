package br.com.danese.strategy.imposto.templateMethod;

import java.util.ArrayList;
import java.util.List;

import br.com.danese.strategy.imposto.Imposto;
import br.com.danese.strategy.imposto.Item;
import br.com.danese.strategy.imposto.Orcamento;

public class IHIT extends TemplateDeImpostoCondicional {

	public IHIT() {
	}

	public IHIT(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.13 + 100;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * (0.01 * orcamento.getItens().size());
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		List<String> noOrcamento = new ArrayList<String>();

		for (Item item : orcamento.getItens()) {
			if (noOrcamento.contains(item.getNome()))
				return true;
			else
				noOrcamento.add(item.getNome());
		}

		return false;
	}
}