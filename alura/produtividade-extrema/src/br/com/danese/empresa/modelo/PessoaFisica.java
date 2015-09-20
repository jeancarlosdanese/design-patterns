package br.com.danese.empresa.modelo;

public class PessoaFisica extends Pessoa {

	public PessoaFisica(String cpf, String nome, String endereco, String email) {
		super(nome, endereco, email);
		this.cpf = cpf;
	}

	final private String cpf;

	public String getCpf() {
		return cpf;
	}
}