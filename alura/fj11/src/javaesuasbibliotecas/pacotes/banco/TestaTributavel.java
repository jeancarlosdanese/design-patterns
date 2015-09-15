package javaesuasbibliotecas.pacotes.banco;

import javaesuasbibliotecas.pacotes.banco.conta.ContaCorrente;
import javaesuasbibliotecas.pacotes.banco.conta.Tributavel;

public class TestaTributavel {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente();
		cc.deposita(100);
		System.out.printf("Tributos: %.2f\n", cc.calculaTributos());
		
		// testando polimorfismo
		Tributavel t = cc;
		System.out.printf("Tributos: %.2f\n", t.calculaTributos());
		
	}
	
}
