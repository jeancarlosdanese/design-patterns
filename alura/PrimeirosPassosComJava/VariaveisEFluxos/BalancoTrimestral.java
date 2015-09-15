class BalancoTrimestral {
	public static void main(String[] args) {
		int gastosJaneiro = 15000;
		int gastosFevereiro = 23000;
		int gastosMarco = 17000;
		int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;
		int mediaMensal = gastosTrimestre / 3;

		System.out.println("Gastos do trimestre: " + gastosTrimestre);
		System.out.println("Média mensal de gastos: " + mediaMensal);

	}
}