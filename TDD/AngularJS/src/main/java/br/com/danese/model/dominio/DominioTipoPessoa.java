package br.com.danese.model.dominio;

public enum DominioTipoPessoa {

	FISICA("Física"), 
	JURIDICA("Jurídica");

	private String descricao;

	private DominioTipoPessoa(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}

}