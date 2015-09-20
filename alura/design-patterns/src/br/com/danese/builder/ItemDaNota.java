package br.com.danese.builder;

public class ItemDaNota {
	private String descricao;
	private double valor;

	public ItemDaNota(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}

	public String getDescricao() {
		return this.descricao;
	}
}