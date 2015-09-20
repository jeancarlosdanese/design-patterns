package br.com.danese.empresa;

public class Fibonacci {

	public int calcula(int n) {

		int n1 = 0;
		int n2 = 1;

		for (int i = 1; i < n; i++) {
			n2 = n2 + n1;
			n1 = n2 - n1;
		}

		return n2;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			System.out.println("fib(" + i + ")=" + new Fibonacci().calcula(i));
		}
	}
}