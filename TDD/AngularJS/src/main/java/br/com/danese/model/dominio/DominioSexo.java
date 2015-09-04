package br.com.danese.model.dominio;

public enum DominioSexo {

	MASCULINO("Masculino"), 
	FEMININO("Feminino");

	private String descricao;

	private DominioSexo(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}

}