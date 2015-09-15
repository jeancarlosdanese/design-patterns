package javaesuasbibliotecas.threads.exemplo1;

public class BarraDeProgresso implements Runnable {

	/*public void executa() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("barra de progresso");
		}
	}*/

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("barra de progresso");
		}
	}
	
}
