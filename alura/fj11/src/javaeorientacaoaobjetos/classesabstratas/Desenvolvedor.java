package javaeorientacaoaobjetos.classesabstratas;

public class Desenvolvedor extends Funcionario {

	@Override
	public double getBonus() {
		return this.salario * 1.1;
	}

}
