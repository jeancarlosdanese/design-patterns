package br.com.danese.model.dominio;

public enum DominioEstadoCivil {

	CASADO("Casado"),
	DESQUITADO("Desquitado"),
	DIVORCIADO("Divorciado"),
	SEPARADO("Separado"),
	SOLTEIRO("Solteiro"),
	VIUVO("Viúvo");

	private String descricao;

	private DominioEstadoCivil(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}

}