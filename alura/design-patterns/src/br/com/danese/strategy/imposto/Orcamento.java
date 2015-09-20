package br.com.danese.strategy.imposto;

import java.util.List;

public class Orcamento {

	private final double valor;
	private List<Item> itens;

	public Orcamento(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public List<Item> getItens() {
		return itens;
	}
}
