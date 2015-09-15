package javaeorientacaoaobjetos.interfaces.calculaarea;

public class Quadrado implements AreaCalculavel {

	private int lado;
	
	public Quadrado(int lado) {
		super();
		this.lado = lado;
	}

	@Override
	public double calculaArea() {
		return this.lado * this.lado;
	}

}
