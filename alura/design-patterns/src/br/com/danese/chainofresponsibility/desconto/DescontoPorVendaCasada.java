package br.com.danese.chainofresponsibility.desconto;

public class DescontoPorVendaCasada implements Desconto {

	private Desconto proximo;

	@Override
	public double deconta(Orcamento orcamento) {
		if(aconteceuVendaCasada(orcamento)) {
			return orcamento.getValor() * 0.05;
		} else {
			return proximo.deconta(orcamento);
		}
 	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

	private boolean aconteceuVendaCasada(Orcamento orcamento) {
		return existe("LAPIS", orcamento) && existe("CANETA", orcamento);
	}
	
	private boolean existe(String nomeDoItem, Orcamento orcamento) {
        for (Item item : orcamento.getItens()) {
            if(item.getNome().equals(nomeDoItem)) return true;
        }
        return false;
    }

}
