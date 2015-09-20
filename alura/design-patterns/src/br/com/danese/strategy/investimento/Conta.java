package br.com.danese.strategy.investimento;

public class Conta {
	private String nome;
	private int numero;
	private int agencia;
	private double saldo;

	public void deposita(double valor) {
		this.saldo += valor;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return this.saldo;
	}
}
