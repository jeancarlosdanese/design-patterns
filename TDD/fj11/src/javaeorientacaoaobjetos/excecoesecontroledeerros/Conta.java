package javaeorientacaoaobjetos.excecoesecontroledeerros;

public abstract class Conta {

	protected double saldo;
	private String nome;
	private int agencia;
	
	public Conta() {}

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
	
	public void deposita(double valor) {
		if(valor < 0) {
			throw new ValorInvalidoException("Você tentou depositar um valor negativo");
		} else {
			this.saldo += valor;
		}
	}
	
}
