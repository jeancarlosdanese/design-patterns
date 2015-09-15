class Conta {
	int numero;
	Cliente titular;
	private double saldo;
	private double limite;

	public void saca(double valor) {
		if(valor <= saldo + limite) {
			this.saldo -= valor;
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

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

}

class Cliente {
	String nome;
	String endereco;
}