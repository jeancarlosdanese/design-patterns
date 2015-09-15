package br.com.danese.chainofresponsibility.desconto;

public class CalculadorDeDescontos {
	
	public double calcula(Orcamento orcamento) {
		Desconto d1 = new DescontoPorCincoItens();
		Desconto d2 = new DescontoPorVendaCasada();
		Desconto d3 = new DescontoPorMaisDeQuinhentosReais();
		Desconto d4 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		
		return d1.deconta(orcamento);
	}
}
