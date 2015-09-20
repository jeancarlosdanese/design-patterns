package br.com.danese.strategy.imposto;

public class ISS extends Imposto {

	public ISS() {
	}

	public ISS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculaOutroImposto(orcamento);
	}

}
