package com.algaworks.model;

public class Voo {

	private String origem;
	private String destino;
	private double precoPassagem;

	public Voo(String origem, String destino, double precoPassagem) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.precoPassagem = precoPassagem;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPrecoPassagem() {
		return precoPassagem;
	}

	public void setPrecoPassagem(double precoPassagem) {
		this.precoPassagem = precoPassagem;
	}

}
