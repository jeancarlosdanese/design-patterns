package javaesuasbibliotecas.javalang;

public class TestaString {

	public static void main(String[] args) {
		String s = "fj11";
		s = s.replaceAll("1", "2");
		System.out.println(s);
		
		System.out.println("contém jf" + s.contains("fj"));
		
		String testTrim = " Mario de Andrade  ";
		System.out.println(testTrim);
		System.out.println(testTrim.trim());
		
		System.out.println("é vazio: " + testTrim.isEmpty());
		
		System.out.println("Tamanho: " + testTrim.length());
		
		BrincarStrings brincarStrings = new BrincarStrings();
		brincarStrings.imprimeLetraPorLetra("Mario de Andrade");
		brincarStrings.inverte("Mario de Andrade");
		
		brincarStrings.invertePalavrasDaFrase("Mario de Andrade é uma escritor fubuloso");
		
		brincarStrings.inverteComStringBuilder("Mario de Andrade é uma escritor fubuloso");
		
	}

}