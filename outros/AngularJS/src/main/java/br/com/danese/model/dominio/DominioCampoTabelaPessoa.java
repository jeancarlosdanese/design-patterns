package br.com.danese.model.dominio;

public enum DominioCampoTabelaPessoa {

	NOME("Nome"), 
	TIPO_PESSOA("Tipo Pessoa ( FISICA | JURIDICA )"),
	DATA_NASCIMENTO("Data de Nascimento ( dd/MM/yyyy )"),
	SEXO("Sexo ( MASCULINO | FEMININO )"),
	ESTADO_CIVIL("Estado Cívil ( SOLTEIRO | CASADO )"),
	CPF_CNPJ("Cpf/Cnpj"),
	LOGRADOURO("Logradouro"),
	NUMERO("Número"), 
	COMPLEMENTO("Complemento"),
	BAIRRO("Bairro"),
	CIDADE("Cidade"),
	ESTADO("Estado ( Somente sigla, Ex: SC, PR, etc."),
	CEP("Cep"),
	TELEFONE_CASA("Telefone de casa, Ex: (55) 5555-5555"),
	TELEFONE_TRABALHO("Telefone de Trabalho, Ex: (55) 5555-5555"),
	TELEFONE_CELULAR("Telefone Celular, Ex: (99) 9999-9999 ou (99) 99999-9999)"),
	EMAIL_CASA("E-mail de casa"),
	EMAIL_TRABALHO("E-mail de trabalho");

	private String descricao;

	private DominioCampoTabelaPessoa(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}
	
}