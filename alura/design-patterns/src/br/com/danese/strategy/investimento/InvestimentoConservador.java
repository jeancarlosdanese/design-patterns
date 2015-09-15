package br.com.danese.strategy.investimento;

public class InvestimentoConservador implements Investimento {

	@Override
	public double calcula(Conta conta) {
		return conta.getSaldo() * 0.008;
	}

}
