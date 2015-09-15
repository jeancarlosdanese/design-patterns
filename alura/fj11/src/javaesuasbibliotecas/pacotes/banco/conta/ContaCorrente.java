package javaesuasbibliotecas.pacotes.banco.conta;

public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente(String nome, int agencia, double saldo) {
		super(nome, agencia, saldo);
	}
	
	public ContaCorrente() {}
	
	public ContaCorrente(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}

	@Override
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 2;
	}

	@Override
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}
	
}
