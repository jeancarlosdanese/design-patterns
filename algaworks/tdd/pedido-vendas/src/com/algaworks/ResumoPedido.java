package com.algaworks;

public class ResumoPedido {

	private double valorTotal;
	private double desconto;

	public ResumoPedido(double valorTotal, double desconto) {
		this.valorTotal = valorTotal;
		this.desconto = desconto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public double getDesconto() {
		return desconto;
	}

}
