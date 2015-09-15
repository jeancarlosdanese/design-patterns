package br.com.danese.chainofresponsibility.desconto;

public interface Desconto  {
	double deconta(Orcamento orcamento);
	void setProximo(Desconto proximo);
}
