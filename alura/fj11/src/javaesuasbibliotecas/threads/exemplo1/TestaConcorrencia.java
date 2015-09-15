package javaesuasbibliotecas.threads.exemplo1;

public class TestaConcorrencia {
	public static void main(String[] args) {
		
		BarraDeProgresso barra = new BarraDeProgresso();
//		barra.executa();
		Thread t1 = new Thread(barra);
		t1.run();
		
		CopiadorDeArquivos copiador = new CopiadorDeArquivos();
//		copiador.executa();
		Thread t2 = new Thread(copiador);
		t2.run();
		
	}
}
