package br.com.danese.chainofresponsibility.desconto;

public class DescontoPorCincoItens implements Desconto {

	private Desconto proximo;

	@Override
	public double deconta(Orcamento orcamento) {
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		} else {
			return proximo.deconta(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
