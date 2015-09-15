package br.com.danese.chainofresponsibility.desconto;

public class SemDesconto implements Desconto {

	@Override
	public double deconta(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto proximo) {
		
	}
	
}
