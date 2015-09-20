package br.com.danese.strategy.imposto;

public class ICMS extends Imposto {

	public ICMS() {
	}

	public ICMS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.1 + calculaOutroImposto(orcamento);
	}

}
