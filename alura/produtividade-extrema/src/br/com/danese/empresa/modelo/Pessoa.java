package br.com.danese.empresa.modelo;

public class Pessoa {

	final private String nome;
	final private String endereco;
	final private String email;

	public Pessoa(String nome, String endereco, String email) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}

}