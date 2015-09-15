class TesteModificador {
	public static void main(String[] args) {
		
		Conta bernardo = new Conta();
		bernardo.numero = 123;
		bernardo.setLimite(100);

		bernardo.deposita(500.0);
		bernardo.saca(500.1 );

		System.out.println(bernardo.getSaldo());
	}
}