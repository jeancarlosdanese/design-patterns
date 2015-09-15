package javaeorientacaoaobjetos.excecoesecontroledeerros;

public class ContaCorrente extends Conta {

	public ContaCorrente(String nome, int agencia, double saldo) {
		super(nome, agencia, saldo);
	}
	
	public ContaCorrente() {}

	@Override
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 2;
	}

}
