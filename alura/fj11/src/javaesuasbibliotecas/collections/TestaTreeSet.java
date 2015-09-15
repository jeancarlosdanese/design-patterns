package javaesuasbibliotecas.collections;

import java.util.TreeSet;

public class TestaTreeSet {
	public static void main(String[] args) {
		
		TreeSet<Integer> numeros = new TreeSet<Integer>();
		
		for (Integer i = 1; i <= 1000; i++) {
			numeros.add(i);
		}
		
		for (Integer i : numeros.descendingSet()) {
			System.out.println(i);
		}
		
	}
}
