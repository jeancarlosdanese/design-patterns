package javaeorientacaoaobjetos.interfaces;

public class Diretor extends Funcionario implements Autenticavel {

	@Override
	public double getBonus() {
		return this.salario * 0.35;
	}

	public void cobraRelatorio() {
		System.out.println("Preciso dos relatórios");
	} 

	@Override
	public boolean autentica(int senha) {
		// TODO Auto-generated method stub
		return false;
	}
}
