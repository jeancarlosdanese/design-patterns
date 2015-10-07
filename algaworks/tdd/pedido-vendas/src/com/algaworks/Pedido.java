package com.algaworks;

import java.util.ArrayList;
import java.util.List;

import com.algaworks.desconto.CalculadoraDescontoFaixa;

public class Pedido {
	
	private CalculadoraDescontoFaixa calculadoraDescontoFaixa;

	private List<ItemPedido> itensPedido = new ArrayList<>();

	public Pedido(CalculadoraDescontoFaixa calculadoraDescontoFaixa) {
		this.calculadoraDescontoFaixa = calculadoraDescontoFaixa;
	}

	public void adicionarItem(ItemPedido itemPedido) {
		validarQuantidadeItens(itemPedido);
		
		itensPedido.add(itemPedido);
	}
 
	public ResumoPedido resumo() {
		double valorTotal = itensPedido.stream().mapToDouble(i -> i.getValorUnitario() * i.getQuantidade()).sum();
		double desconto = calculadoraDescontoFaixa.descosto(valorTotal);
		
		// Refatorado para padrao: chain of responsibilite
		/*if (valorTotal > 300.0 && valorTotal <= 800) {
			desconto = valorTotal * 0.04;
		} else if (valorTotal > 800.0 && valorTotal <= 1000) {
			desconto = valorTotal * 0.06;
		} else if (valorTotal > 1000) {
			desconto = valorTotal * 0.08;
		}*/

		return new ResumoPedido(valorTotal, desconto);
	}
	
	private void validarQuantidadeItens(ItemPedido itemPedido) {
		if(itemPedido.getQuantidade() < 0)
			throw new QuantidadeItensInvalidaException();
	}

}