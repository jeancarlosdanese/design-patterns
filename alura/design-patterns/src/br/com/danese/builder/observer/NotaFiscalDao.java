package br.com.danese.builder.observer;

import br.com.danese.builder.NotaFiscal;

public class NotaFiscalDao implements AcaoAposGerarNota {
	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("salvando no banco");
	}
}