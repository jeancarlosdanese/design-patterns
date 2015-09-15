class ImprimeFatoriaisUmADez {
	public static void main(String[] args) {
		long fatorial = 1;
		for (long i = 1; i <= 40; i++ ) {
			fatorial *= i;
			System.out.println("Farorial de " + i + " é = " + + fatorial);
		}
	}
}