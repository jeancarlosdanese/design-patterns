package javaesuasbibliotecas.pacotes.banco.conta;

public abstract class Conta {
	protected int numero;
	protected double saldo;
	protected String nome;
	private int agencia;
	
	public Conta() {}
	
	public Conta(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}

	public Conta(String nome, int agencia, double saldo) {
		super();
		this.nome = nome;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void imprime() {
		System.out.println("Titular: " + nome);
		System.out.println("Agência: " + agencia);
		System.out.printf("O saldo é: %.2f\n", saldo);
	}

	public abstract void atualiza(double taxa);
	
	public void saca(double valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente");
		}
	}
	
	/**
	 * Realiza um saque na conta conforme valor passado
	 * @param valor: Valor a ser sacado
	 * @throws Exception: caso valor insuficiente
	 */
	public void deposita(double valor) {
		if(valor < 0) {
			throw new ValorInvalidoException("Você tentou depositar um valor negativo");
		} else {
			this.saldo += valor;
		}
	}
	
	@Override
	public String toString() {
		return "Esse objeto é uma conta e seu saldo é: " + this.saldo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Conta outra = (Conta) obj;
        return this.numero == outra.numero && 
               this.nome.equals(outra.nome);
	}
}
