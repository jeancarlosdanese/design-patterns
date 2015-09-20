package br.com.danese.empresa.modelo;

public class PessoaJuridica extends Pessoa {

	public PessoaJuridica(String cnpj, String nome, String endereco, String email) {
		super(nome, endereco, email);
		this.cnpj = cnpj;
	}

	final private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

}