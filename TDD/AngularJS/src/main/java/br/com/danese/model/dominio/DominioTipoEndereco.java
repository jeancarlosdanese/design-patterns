package br.com.danese.model.dominio;

public enum DominioTipoEndereco {

	CASA("Casa"),
	TRABALHO("Trabalho"),
	OUTRO("Outro");

	private String descricao;

	private DominioTipoEndereco(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}
}