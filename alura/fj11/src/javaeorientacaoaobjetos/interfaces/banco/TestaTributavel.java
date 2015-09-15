package javaeorientacaoaobjetos.interfaces.banco;

public class TestaTributavel {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente();
		cc.deposita(100);
		System.out.printf("Tributos: %.2f\n", cc.calculaTributos());
		
		// testando polimorfismo
		Tributavel t = cc;
		System.out.printf("Tributos: %.2f\n", t.calculaTributos());
		
	}
	
}
