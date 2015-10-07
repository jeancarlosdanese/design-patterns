package com.algaworks.desconto;

public class CalculadorSemDesconto extends CalculadoraDescontoFaixa {

	public CalculadorSemDesconto(CalculadoraDescontoFaixa proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}

}
