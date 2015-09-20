package br.com.danese;

public class GerenciadorDeDividas {
	public void efetuaPagamentos(Divida divida, String nomePagador, String cnpjPagador, double valor) {
		Pagamento pagamento = new Pagamento();
		pagamento.setDocumentoPagador(cnpjPagador);
		pagamento.setPagador(nomePagador);
		pagamento.setValor(valor);
		divida.registra(pagamento);
		
	}
}
