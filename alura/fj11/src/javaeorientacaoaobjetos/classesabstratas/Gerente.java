package javaeorientacaoaobjetos.classesabstratas;

public class Gerente extends Funcionario {

	@Override
	public double getBonus() {
		return this.salario * 1.2;
	}
	
	public void cobraEntrega() {
		System.out.println("Está pronto?");
	}

}
