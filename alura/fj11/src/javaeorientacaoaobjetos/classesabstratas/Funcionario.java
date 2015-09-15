package javaeorientacaoaobjetos.classesabstratas;

public abstract class Funcionario {

	private String nome;
	protected double salario;
	public abstract double getBonus();
	
	public String getNome() {
		return nome;
	}
	
}
