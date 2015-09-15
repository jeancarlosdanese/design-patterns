package br.com.danese.strategy.investimento;

import java.util.Random;

public class InvestimentoModerado implements Investimento {

	private Random random;

	public InvestimentoModerado() {
		this.random = new Random();
	}

	public double calcula(Conta conta) {
		if (random.nextInt(2) == 0)
			return conta.getSaldo() * 0.025;
		else
			return conta.getSaldo() * 0.007;
	}

}
