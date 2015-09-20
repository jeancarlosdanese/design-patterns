package br.com.danese.strategy.imposto;

public abstract class Imposto {

	private final Imposto outroImposto;

	public Imposto() {
		outroImposto = null;
	}

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	public abstract double calcula(Orcamento orcamento);
	
	protected double calculaOutroImposto(Orcamento orcamento) {
		if(outroImposto == null) return 0;
		return outroImposto.calcula(orcamento);
	}

}
