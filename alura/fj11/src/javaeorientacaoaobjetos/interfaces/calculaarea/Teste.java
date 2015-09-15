package javaeorientacaoaobjetos.interfaces.calculaarea;

public class Teste {
	public static void main(String[] args) {
		AreaCalculavel r = new Retangulo(2, 3);
		System.out.println("Área do retangulo: " + r.calculaArea());
		
		AreaCalculavel q = new Quadrado(2);
		System.out.println("Área do quadrado: " + q.calculaArea());
		
		AreaCalculavel c = new Circulo(3);
		System.out.println(c.calculaArea());
	}
}
