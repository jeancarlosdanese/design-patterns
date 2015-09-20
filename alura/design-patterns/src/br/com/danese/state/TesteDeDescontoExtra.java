package br.com.danese.state;

public class TesteDeDescontoExtra {

	public static void main(String[] args) {
		Orcamento reforma = new Orcamento(500.0);
		
		reforma.aplicaDescontoExtra();
		
		System.out.println(reforma.estadoAtual + " - " + reforma.valor);
		
		reforma.aprova();

		reforma.aplicaDescontoExtra();
		
		System.out.println(reforma.estadoAtual + " - " + reforma.valor);
		
		reforma.finaliza();
		
		System.out.println(reforma.estadoAtual + " - " + reforma.valor);
		
		reforma.aplicaDescontoExtra();
	}
	
}
