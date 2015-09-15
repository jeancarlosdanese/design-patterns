package javaesuasbibliotecas.javalang;

import javaesuasbibliotecas.pacotes.banco.conta.Conta;
import javaesuasbibliotecas.pacotes.banco.conta.ContaCorrente;

public class TestaInteger {
	public static void main(String[] args) {
		Integer x1 = new Integer(10);
		Integer x2 = new Integer(10);

		if (x1.equals(x2)) {
			System.out.println("igual");
		} else {
			System.out.println("diferente");
		}
		
		int i0 = Integer.parseInt("3");
		int i1 = Integer.parseInt("a");
		
	}
}
