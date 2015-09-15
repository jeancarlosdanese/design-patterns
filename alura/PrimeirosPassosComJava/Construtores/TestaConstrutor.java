class TestaConstrutor {
	public static void main(String[] args) {
		
		Conta bernardo = new Conta(123, new Cliente("Bernardo"), 100);

		bernardo.deposita(500.0);
		bernardo.saca(500.1 );

		System.out.println(bernardo.getSaldo());
	}
}