package br.com.danese;

import java.util.Calendar;

public class MinhaAplicacao {
	public static void main(String[] args) {
//		BancoDeDados bd = new BancoDeDados("servidor", "usuario", "senha");
		
		ArmazenadorEmArquivo bd = new ArmazenadorEmArquivo();
		
		BalancoEmpresa balanco = new BalancoEmpresa(bd);

		Documento cnpjPapelaria = new Cnpj("00.000.001/0001-01");
		Divida divida = new Divida(cnpjPapelaria);
		divida.setTotal(100);
		divida.setCredor("Papelaria");

		balanco.registraDivida(divida);

		Pagamento pagamento = new Pagamento();
		pagamento.setPagador("Luiz");
		pagamento.setDocumentoPagador("000.000.001-01");
		pagamento.setValor(100);
		pagamento.setData(Calendar.getInstance());

		balanco.pagaDivida(cnpjPapelaria, pagamento);

//		bd.desconecta();
	}
}