package br.com.danese;

public class BalancoEmpresa {
	
	private ArmazenadorDeDividas bancoDeDados;

	public BalancoEmpresa(ArmazenadorDeDividas bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}

	public void registraDivida(Divida divida) {
		bancoDeDados.salva(divida);
	}

	public void pagaDivida(Documento documentoCredor, Pagamento pagamento) {
		Divida divida = bancoDeDados.carrega(documentoCredor);
		if (divida != null) {
			divida.registra(pagamento);
		}
		bancoDeDados.salva(divida);
	}
}