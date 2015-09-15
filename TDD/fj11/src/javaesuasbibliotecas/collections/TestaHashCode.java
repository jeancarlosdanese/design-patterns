package javaesuasbibliotecas.collections;

import java.util.HashSet;
import java.util.Set;

import javaesuasbibliotecas.collections.banco.conta.Conta;
import javaesuasbibliotecas.collections.banco.conta.ContaPoupanca;

public class TestaHashCode {
	public static void main(String[] args) {
		Set<Conta> contas = new HashSet<Conta>();

		ContaPoupanca c1 = new ContaPoupanca(1, 123, 400);
		contas.add(c1);
		contas.add(c1);
		
		ContaPoupanca c2 = new ContaPoupanca(1, 123, 500);
		contas.add(c2);
		
		ContaPoupanca c3 = new ContaPoupanca(2, 123, 300);
		contas.add(c3);

		for (Conta conta : contas) {
			System.out.println(conta);
		}

	}
}
