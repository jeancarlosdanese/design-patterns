class Conta {
	int numero;
	Cliente titular;
	private double saldo;
	private double limite;

	private Conta(int numero, Cliente titular) {
		this.numero = numero;
		this.titular = titular;
	}

	public Conta(int numero, Cliente titular, double limite) {
		this.numero = numero;
		this.titular = titular;
		this.limite = limite;
	}

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
	private String nome;
	private String endereco;

	public Cliente(String nome) {
		this.nome = nome;
	}

	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

}