package javaesuasbibliotecas.javalang;

public class BrincarStrings {
	public void imprimeLetraPorLetra(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			System.out.println(texto.charAt(i));
		}
	}

	public void inverte(String texto) {
		for (int i = texto.length() - 1; i >= 0; i--) {
			System.out.print(texto.charAt(i));
		}
		System.out.println("");
	}

	public void invertePalavrasDaFrase(String texto) {
		String[] palavras = texto.split(" ");
		for (int i = palavras.length - 1; i >= 0; i--) {
			System.out.print(palavras[i] + " ");
		}
		System.out.println("");
	}
	
	public void inverteComStringBuilder(String texto) {
        System.out.print("\t");
        StringBuilder invertido = new StringBuilder(texto).reverse();
        System.out.println(invertido);
    }
}
