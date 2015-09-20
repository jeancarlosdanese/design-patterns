package br.com.danese.empresa.model.financeiro;

import br.com.danese.empresa.model.comercial.Cliente;
import br.com.danese.empresa.model.comercial.FormaDePagamento;

public class Pagamento {

	private Cliente cliente;
	private FormaDePagamento forma;
	private double valor;

	public Pagamento(Cliente cliente, FormaDePagamento forma, double valor) {
		this.cliente = cliente;
		this.forma = forma;
		this.valor = valor;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public FormaDePagamento getForma() {
		return forma;
	}
	
	public double getValor() {
		return valor;
	}
}
