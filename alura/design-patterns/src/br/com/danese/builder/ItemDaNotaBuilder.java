package br.com.danese.builder;

class ItemDaNotaBuilder {
	private String descricao;
	private double valor;

	public ItemDaNotaBuilder comDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public ItemDaNotaBuilder comValor(double valor) {
		this.valor = valor;
		return this;
	}

	public ItemDaNota constroi() {
		return new ItemDaNota(descricao, valor);
	}
}