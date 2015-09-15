package javaesuasbibliotecas.pacotes.banco;

import javaesuasbibliotecas.pacotes.banco.conta.ContaCorrente;
import javaesuasbibliotecas.pacotes.banco.conta.GerenciadorDeImpostoDeRenda;
import javaesuasbibliotecas.pacotes.banco.conta.SeguroDeVida;

public class TestaGerenciadorDeImpostoDeRenda {
	public static void main(String[] args) {

		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();

		SeguroDeVida sv = new SeguroDeVida();
		gerenciador.adiciona(sv);

		ContaCorrente cc = new ContaCorrente();
		cc.deposita(1000);
		gerenciador.adiciona(cc);

		System.out.printf("Total de impostos: %.2f\n", gerenciador.getTotal());
	}
}