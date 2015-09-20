package br.com.danese.builder;

import br.com.danese.builder.observer.AcaoAposGerarNota;

class Multiplicador implements AcaoAposGerarNota {
	
	private final double fator;

	public Multiplicador(double fator) {
		this.fator = fator;
	}

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println(notaFiscal.getValorBruto() * this.fator);
	}
}