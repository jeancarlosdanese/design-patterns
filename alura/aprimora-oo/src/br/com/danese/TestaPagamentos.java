package br.com.danese;

public class TestaPagamentos {
	
	public static void main(String[] args) {
		
		Pagamentos pagamentos = new Pagamentos();
		Pagamento p1 = new Pagamento();
		Pagamento p2 = new Pagamento();
		p1.setValor(105);
		p2.setValor(25);
		
		pagamentos.registra(p1);
		pagamentos.registra(p2);
		
		System.out.println(pagamentos.getValorPago());
		
	}

}
