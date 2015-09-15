package javaesuasbibliotecas.javalang;

public class DesafioConversaoDeNumeros {

	public static void main(String[] args) {
		String numero = "762";
		System.out.println("Imprimindo a string: " + numero);

		int resultado = converteParaInt(numero);
		System.out.println("Imprimindo o int: " + resultado);
	}

	private static int converteParaInt(String numero) {
		int resultado = 0;
		while (numero.length() > 0) {
			char algarismo = numero.charAt(0);
			resultado = resultado * 10 + (algarismo - '0');
			numero = numero.substring(1);
		}
		return resultado;
	}
}