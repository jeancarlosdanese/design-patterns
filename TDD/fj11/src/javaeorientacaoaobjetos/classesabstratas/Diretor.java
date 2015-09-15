package javaeorientacaoaobjetos.classesabstratas;

public class Diretor extends Funcionario {

	@Override
	public double getBonus() {
		return this.salario * 0.35;
	}

	public void cobraRelatorio() {
		System.out.println("Preciso dos relatórios");
	}
}
