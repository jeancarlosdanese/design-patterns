package javaeorientacaoaobjetos.herancarestricaoepolimorfismo;

public class Conta {

	protected double saldo;
	private String nome;
	private int agencia;

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
		System.out.println(nome);
		System.out.println(agencia);
		System.out.println(saldo);
	}

	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa;
	}
	
	public void saca(double valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente");
		}
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
}
