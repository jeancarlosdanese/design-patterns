package javaesuasbibliotecas.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javaesuasbibliotecas.collections.banco.conta.ContaPoupanca;

public class TestaOrdenacao {
	public static void main(String[] args) {
		List<ContaPoupanca> contas = new ArrayList<ContaPoupanca>();
		
		Random random = new Random();
		
		long inicio = System.currentTimeMillis();
		
		for (int i = 100; i > 0; i--) {
			double saldo = random.nextDouble() * random.nextInt(1000);
			ContaPoupanca c1 = new ContaPoupanca(random.nextInt(200), 123, saldo);
			contas.add(c1);
		}
		
		Collections.sort(contas);
		
		for (ContaPoupanca conta : contas) {
			System.out.println(conta);
		}
		
		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		
		System.out.println("Tempo: " + tempo);

	}
}
