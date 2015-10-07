package br.com.danese.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2 {
	public static void main(String... args) {
		
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		
		System.out.println("forEach comum");
		for (Usuario u : usuarios) {
			System.out.println(u.getNome());
		}
		
		System.out.println("===============================\n");
		System.out.println("forEach com uso de Consumer de java.util.function.Consumer");
		usuarios.forEach(new Consumer<Usuario>() {
			public void accept(Usuario u) {
				System.out.println(u.getNome());
			}
		});
		
		System.out.println("===============================\n");
		System.out.println("forEach com uso da classe Mostrador Consumer de java.util.function.Consumer");
		Mostrador mostrador = new Mostrador();
		usuarios.forEach(mostrador);
		
		System.out.println("===============================\n");
		System.out.println("forEach com uso de Lambda de java.util.function.Consumer");
		usuarios.forEach((Usuario u) -> {System.out.println(u.getNome());});
		
		System.out.println("===============================\n");
		System.out.println("forEach com uso de Lambda1 de java.util.function.Consumer");
		usuarios.forEach((Usuario u) -> System.out.println(u.getNome()));
		
		System.out.println("===============================\n");
		System.out.println("forEach com uso de Lambda2 de java.util.function.Consumer");
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		System.out.println("===============================\n");
		System.out.println("forEach com uso de Lambda2 de java.util.function.Consumer");
		usuarios.forEach(u -> {u.tornaModerador(); System.out.println("É moderador: " + u.isModerador());});
		
	}
}