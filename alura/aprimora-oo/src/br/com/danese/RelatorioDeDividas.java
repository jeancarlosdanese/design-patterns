package br.com.danese;

import java.text.NumberFormat;

public class RelatorioDeDividas {
	private Divida divida;

	public RelatorioDeDividas(Divida divida) {
		super();
		this.divida = divida;
	}

	public void geraRelatorio(NumberFormat formater) {
		System.out.println("Cnpj do credor: " + divida.getDocumentoCredor());
		System.out.println("Credor: " + divida.getCredor());

		System.out.println("Valor da divida: " + formater.format(divida.getTotal()));
		System.out.println("Valor pago: " + formater.format(divida.getValorPago()));
	}

}
