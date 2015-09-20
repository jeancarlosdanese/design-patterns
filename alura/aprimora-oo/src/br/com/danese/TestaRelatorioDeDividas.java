package br.com.danese;

import java.text.NumberFormat;
import java.util.Locale;

public class TestaRelatorioDeDividas {
	public static void main(String[] args) {
		Divida divida = new Divida(new Cnpj("01.001.001/0001-01"));
		divida.setCredor("Mario de Andrade");
		divida.setTotal(100.0);

		Pagamento pagamento = new Pagamento();
		pagamento.setDocumentoPagador("02.002.002/0002.02");
		pagamento.setPagador("Adão");
		pagamento.setValor(20);
		divida.registra(pagamento);

		RelatorioDeDividas relatorioDeDividas = new RelatorioDeDividas(divida);
		NumberFormat formater = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		relatorioDeDividas.geraRelatorio(formater);
	}
}
