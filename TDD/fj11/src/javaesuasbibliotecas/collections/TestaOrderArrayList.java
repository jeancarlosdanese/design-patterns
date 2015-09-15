package javaesuasbibliotecas.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaOrderArrayList {
	public static void main(String[] args) {
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		for (Integer i = 1; i <= 1000; i++) {
			numeros.add(i);
		}
		
		Collections.sort(numeros);
		Collections.reverse(numeros);
		
		for (Integer i : numeros) {
			System.out.println(i);
		}
		
	}
}
