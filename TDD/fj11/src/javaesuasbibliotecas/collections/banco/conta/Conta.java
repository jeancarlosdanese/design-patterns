package javaesuasbibliotecas.collections.banco.conta;

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

	public Conta(int numero, int agencia, double saldo) {
		this.numero = numero;
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
		return "conta: " + this.numero + " - R$ " + this.saldo;
	}
	

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
	
}
