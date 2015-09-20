package br.com.danese.chainofresponsibility.conta;

import java.time.LocalDate;

public class Conta {
	private String titular;
	private LocalDate dataAbertura;
	protected double saldo;
	
	protected EstadoDaConta estado;


	public Conta(String titular, LocalDate dataAbertura, double saldo) {
		this.titular = titular;
		this.dataAbertura = dataAbertura;
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void saca(double valor) {
		estado.saca(this, valor);
	}

	public void deposita(double valor) {
		estado.deposita(this, valor);
	}

	@Override
	public String toString() {
		return titular + " - " + dataAbertura + " - " + saldo;
	}
}