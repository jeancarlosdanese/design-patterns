package com.algaworks.desconto;

public class CalculadorDescontoPrimeiraFaixa extends CalculadoraDescontoFaixa {

	public CalculadorDescontoPrimeiraFaixa(CalculadoraDescontoFaixa proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 300.0 && valorTotal <= 800.0)
			return valorTotal * 0.04;
		
		return -1;
	}

}
