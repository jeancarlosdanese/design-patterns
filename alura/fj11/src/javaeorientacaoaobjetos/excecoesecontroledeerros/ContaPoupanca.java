package javaeorientacaoaobjetos.excecoesecontroledeerros;

public class ContaPoupanca extends Conta {

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
	
}
