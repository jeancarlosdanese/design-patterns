package javaeorientacaoaobjetos.classesabstratas;

public class TestaConta {

	public static void main(String[] args) {
		Conta conta = new ContaCorrente("Bernardo", 123, 152);
		conta.imprime();
		
		ContaCorrente contaCorrente = new ContaCorrente("Jean", 234, 251.1);
		contaCorrente.imprime();

		ContaPoupanca contaPoupanca = new ContaPoupanca("Liane", 321, 274.5);
		contaPoupanca.imprime();
		
	}

}
