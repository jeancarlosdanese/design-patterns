package com.algaworks.desconto;

public class CalculadorDescontoTerceiraFaixa extends CalculadoraDescontoFaixa {

	public CalculadorDescontoTerceiraFaixa(CalculadoraDescontoFaixa proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if (valorTotal > 1000.0)
			return valorTotal * 0.08;

		return -1;
	}

}
