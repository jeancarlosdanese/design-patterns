package javaesuasbibliotecas.pacotes.banco;

import javaesuasbibliotecas.pacotes.banco.conta.ContaCorrente;
import javaesuasbibliotecas.pacotes.banco.conta.ValorInvalidoException;

public class TestaConta {

	public static void main(String[] args) {
		
		ContaCorrente contaCorrente = new ContaCorrente("Jean", 234, 251.1);
		try {
			contaCorrente.deposita(-100);
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());;
		}
		contaCorrente.imprime();

	}

}
