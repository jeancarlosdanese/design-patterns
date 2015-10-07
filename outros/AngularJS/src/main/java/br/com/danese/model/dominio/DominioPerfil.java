package br.com.danese.model.dominio;

public enum DominioPerfil {

	ADMINISTRADOR("Administrador"), 
	ADVOGADO("Advogado"),
	ALUNO("Aluno"),
	CANDIDATO("Candidato"),
	CONTRATANTE("Contratante"),
	CONVENIADO("Conveniado"),
	FINANCEIRO("Financeiro"), 
	FORNECEDOR("Fornecedor"),
	INTERESSADO("Interessado"),
	INSTRUTOR("Instrutor"),
	INSTRUTORREPO("Instrutor Contratado"),
	SECRETARIO("Secretario"),
	VENDEDOR("Vendedor");

	
	private String descricao;

	private DominioPerfil(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}
	
}