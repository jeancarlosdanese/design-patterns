package com.algaworks;

import com.algaworks.desconto.CalculadorDescontoPrimeiraFaixa;
import com.algaworks.desconto.CalculadorDescontoSegundaFaixa;
import com.algaworks.desconto.CalculadorDescontoTerceiraFaixa;
import com.algaworks.desconto.CalculadorSemDesconto;
import com.algaworks.desconto.CalculadoraDescontoFaixa;

public class PedidoBuilder {

	private Pedido instancia;

	public PedidoBuilder() {
		CalculadoraDescontoFaixa calculadoraDescontoFaixa = 
				new CalculadorDescontoTerceiraFaixa(
						new CalculadorDescontoSegundaFaixa(
								new CalculadorDescontoPrimeiraFaixa(
										new CalculadorSemDesconto(null))));
		instancia = new Pedido(calculadoraDescontoFaixa);
	}
	
	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));
		return this;
	}
	
	public Pedido construir() {
		return instancia;
	}
	
}
