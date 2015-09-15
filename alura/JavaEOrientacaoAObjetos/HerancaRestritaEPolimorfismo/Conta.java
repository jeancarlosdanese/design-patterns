class Conta {
	protected double saldo;

	public void saca(double valor) {
		if(valor <= saldo) {
			this.saldo -= valor + 0.1;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public void deposita(double valor) {
		this.saldo += valor;
	}

	public double getSaldo() {
		return saldo;
	}

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa;
	}

}

class ContaCorrente extends Conta {
	public ContaCorrente() {}

	public ContaCorrente(double saldo) {
		this.saldo = saldo;
	}

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 2;
	}
}

class ContaPoupanca extends Conta {
	public ContaPoupanca() {}

	public ContaPoupanca(double saldo) {
		this.saldo = saldo;
	}	
	public void saca(double valor) {
		if(valor <= saldo) {
			this.saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 3;
	}
}

class TestaContas {
	public static void main(String[] args) {
		Conta cc = new ContaCorrente(900);
		System.out.println(cc.getSaldo());

		cc.deposita(100);
		System.out.println(cc.getSaldo());

		cc.atualiza(0.1);
		System.out.println(cc.getSaldo());

		cc.saca(300);
		System.out.println(cc.getSaldo());

		Conta cp = new ContaPoupanca(900);
		System.out.println(cp.getSaldo());

		cp.deposita(100);
		System.out.println(cp.getSaldo());

		cp.atualiza(0.1);
		System.out.println(cp.getSaldo());

		cp.saca(300);
		System.out.println(cp.getSaldo());
	}
}