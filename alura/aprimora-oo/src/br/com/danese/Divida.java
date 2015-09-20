package br.com.danese;

public class Divida {
	private double total;
	private Pagamentos pagamentos = new Pagamentos();
	private String credor;
	private Documento documentoCredor;

	public Divida(Documento documentoCredor) {
		this.documentoCredor = documentoCredor;
	}

	public String 
	getCredor() {
		return this.credor;
	}

	public Documento getDocumentoCredor() {
		return documentoCredor;
	}

	public double getTotal() {
		return this.total;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void registra(Pagamento pagamento) {
		pagamentos.registra(pagamento);
	}

	public double getValorPago() {
		return pagamentos.getValorPago();
	}
}