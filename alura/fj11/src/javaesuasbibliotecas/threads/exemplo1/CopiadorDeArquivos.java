package javaesuasbibliotecas.threads.exemplo1;

public class CopiadorDeArquivos implements Runnable {

	/*public void executa() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("copiador");
		}
	}*/

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("copiador");
		}
	}

}
