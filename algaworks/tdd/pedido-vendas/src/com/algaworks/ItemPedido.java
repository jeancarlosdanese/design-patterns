package com.algaworks;

public class ItemPedido {
	public String descriao;
	public double valorUnitario;
	public int quantidade;

	public ItemPedido(String descriao, double valorUnitario, int quantidade) {
		this.descriao = descriao;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	public String getDescriao() {
		return descriao;
	}

	public void setDescriao(String descriao) {
		this.descriao = descriao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}