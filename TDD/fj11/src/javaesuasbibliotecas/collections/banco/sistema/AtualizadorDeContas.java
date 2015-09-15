package javaesuasbibliotecas.collections.banco.sistema;

import javaesuasbibliotecas.pacotes.banco.conta.Conta;

public class AtualizadorDeContas {

	private double saldoTotal = 0;
	private double selic;

	public AtualizadorDeContas(double selic) {
		this.selic = selic;
	}

	public void roda(Conta c) {
		System.out.println("===============================");
		System.out.printf("Saldo Anterior: %.2f\n", c.getSaldo()); // aqui você
																// imprime o
																// saldo
																// anterior
		c.atualiza(this.selic); // atualiza a conta com a taxa selic,
		System.out.printf("Saldo Atualizado: %.2f\n", c.getSaldo()); // e depois
																	// imprime o
																	// saldo
																	// final
		this.saldoTotal += c.getSaldo(); // lembrando de somar o saldo final ao
											// atributo saldoTotal
	}

	// outros métodos, colocar o getter para saldoTotal!
	public double getSaldoTotal() {
		return this.saldoTotal;
	}

}
