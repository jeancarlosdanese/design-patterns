package br.com.danese.strategy.imposto;

public class ICCC extends Imposto {
	
	public ICCC() {}
	
	public ICCC(Imposto outroImposto) {
		super(outroImposto);
	}
	
	@Override
	public double calcula(Orcamento orcamento) {
		if(orcamento.getValor() < 1000) {
			return orcamento.getValor() * 0.05 + calculaOutroImposto(orcamento);
		} else if(orcamento.getValor() <= 3000) {
			return orcamento.getValor() * 0.07 + calculaOutroImposto(orcamento);
		} else {
			return orcamento.getValor() * 0.08 + 30.0 + calculaOutroImposto(orcamento);
		}
	}
	
}
