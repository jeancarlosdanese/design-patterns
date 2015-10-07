package br.com.danese.model.dominio;

public enum DominioTipoTelefone {

	CELULAR("Celular"), 
	CASA("Casa"), 
	TRABALHO("Trabalho"),
	PRINCIPAL("Principal"),
	FAX_DO_TRABALHO("Fax do trabalho"),
	FAX_DE_CASA("Fax de casa"),
	PAGER("Pager"),
	OUTRO("Outro");

	private String descricao;

	private DominioTipoTelefone(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}
}