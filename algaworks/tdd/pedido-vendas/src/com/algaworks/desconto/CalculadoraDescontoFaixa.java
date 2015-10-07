package com.algaworks.desconto;

public abstract class CalculadoraDescontoFaixa {

	private CalculadoraDescontoFaixa proximo;

	public CalculadoraDescontoFaixa(CalculadoraDescontoFaixa proximo) {
		this.proximo = proximo;
	}

	public double descosto(double valorTotal) {
		double desconto = calcular(valorTotal);

		if (desconto == -1)
			return proximo.descosto(valorTotal);

		return desconto;
	}

	protected abstract double calcular(double valorTotal);

}
