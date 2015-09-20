package br.com.danese.builder;

import java.util.ArrayList;

import br.com.danese.builder.observer.AcaoAposGerarNota;
import br.com.danese.builder.observer.EnviadorDeEmail;
import br.com.danese.builder.observer.NotaFiscalDao;

public class TesteDaNotaFiscal {

	public static void main(String[] args) {
		
		ArrayList<AcaoAposGerarNota> acoesAposGerarNota = new ArrayList<AcaoAposGerarNota>();
		acoesAposGerarNota.add(new EnviadorDeEmail());
		acoesAposGerarNota.add(new NotaFiscalDao());
		acoesAposGerarNota.add(new Multiplicador(2));
		acoesAposGerarNota.add(new Multiplicador(3));
		acoesAposGerarNota.add(new Multiplicador(5.5));
		
		NotaFiscalBuilder builder = new NotaFiscalBuilder(acoesAposGerarNota);
		
		builder.paraEmpresa("Danese Informática Ltda ME")
		.comCnpj("01.111.121/0001-33")
		.comItem(new ItemDaNota("Item 1", 200.0))
		.comItem(new ItemDaNota("Item 1", 300.0))
		.comItem(new ItemDaNota("Item 1", 400.0))
		.comObservacoes("Observações")
		.naDataAtual();
		
		NotaFiscal nf = builder.constroi();
		
		System.out.println(nf.getValorBruto());
	}
}
