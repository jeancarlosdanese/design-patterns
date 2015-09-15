package br.com.danese.chainofresponsibility;

import br.com.danese.chainofresponsibility.desconto.CalculadorDeDescontos;
import br.com.danese.chainofresponsibility.desconto.Item;
import br.com.danese.chainofresponsibility.desconto.Orcamento;

public class TesteDeDescontos {
	
	public static void main(String[] args) {
		CalculadorDeDescontos descontos = new CalculadorDeDescontos();
		
		Orcamento orcamento = new Orcamento(600.0);
		orcamento.adicionaItem(new Item("CANETA", 250.0));
		orcamento.adicionaItem(new Item("LAPIS", 250.0));
		
		double descontoFinal = descontos.calcula(orcamento);
		
		System.out.println(descontoFinal);
	}
	
}
