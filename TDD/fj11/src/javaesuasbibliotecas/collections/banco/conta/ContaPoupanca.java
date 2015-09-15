package javaesuasbibliotecas.collections.banco.conta;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca> {

	public ContaPoupanca(int numero, int agencia, double saldo) {
		super(numero, agencia, saldo);
	}
	
	public ContaPoupanca(String nome, int agencia, double saldo) {
		super(nome, agencia, saldo);
	}
	
	@Override
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 3;
	}
	
	@Override
	public void deposita(double valor) {
		this.saldo += saldo - 0.1;
	}

	@Override
	public int compareTo(ContaPoupanca outraConta) {
		return this.getNumero() - outraConta.getNumero();
	}
	
}
