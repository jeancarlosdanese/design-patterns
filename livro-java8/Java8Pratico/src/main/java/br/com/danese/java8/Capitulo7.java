package br.com.danese.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Capitulo7 {
	public static void main (String... args) throws Exception {

		Usuario u1 = new Usuario("Paulo Silveira", 150);
		Usuario u2 = new Usuario("Rodrigo Turini", 120);
		Usuario u3 = new Usuario("Guilherme Silveira", 90);

		List<Usuario> usuarios = Arrays.asList(u1, u2, u3);

		usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
		usuarios.subList(0,1).forEach(Usuario::tornaModerador);

		Collections.sort(usuarios, new Comparator<Usuario>() {
			@Override
			public int compare(Usuario u1, Usuario u2) {
				return u1.getPontos() - u2.getPontos();
			}
		});

		Collections.reverse(usuarios);
		List<Usuario> top10 = usuarios.subList(0, 1);
		for(Usuario usuario : top10) {
			usuario.tornaModerador();
		}

		Stream<Usuario> stream = usuarios.stream()
			.filter(u -> u.getPontos() > 100);
	
		stream.forEach(System.out::println);

		Supplier<ArrayList<Usuario>> supplier = ArrayList::new;
		BiConsumer<ArrayList<Usuario>, Usuario> accumulator = ArrayList::add;
		BiConsumer<ArrayList<Usuario>,ArrayList<Usuario>> combiner = ArrayList::addAll;

		List<Usuario> maisQue100 = usuarios.stream()
			.filter(u -> u.getPontos() > 100)
			.collect(supplier, accumulator, combiner);
		
		List<Usuario> maisQue100a = usuarios.stream()
		.filter(u -> u.getPontos() > 100)
		.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		List<Usuario> maisQue100boa = usuarios.stream()
			.filter(u -> u.getPontos() > 100)
			.collect(Collectors.toList());

		Set<Usuario> maisQue100set = usuarios
				.stream()
				.filter(u -> u.getPontos() > 100)
				.collect(Collectors.toSet());
		
		ArrayList<Integer> pontos = new ArrayList<>();
		usuarios.forEach(u -> pontos.add(u.getPontos()));

		List<Integer> pontos2 = usuarios.stream()
			.map(u -> u.getPontos())
			.collect(Collectors.toList());

		List<Integer> pontos3 = usuarios.stream()
			.map(Usuario::getPontos)
			.collect(Collectors.toList());

		Stream<Integer> stream2 = usuarios.stream()
			.map(Usuario::getPontos);

		IntStream stream3 = usuarios.stream()
			.mapToInt(Usuario::getPontos);

		double pontuacaoMedia = usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.average()
			.getAsDouble();

		usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.average()
			.orElseThrow(IllegalStateException::new);

		List<Usuario> vazia = Collections.emptyList();


		double media = vazia.stream()
			.mapToInt(Usuario::getPontos)
			.average()
			.orElse(0.0);

		OptionalDouble media2 = usuarios
			.stream()
			.mapToInt(Usuario::getPontos)
			.average();

		double pontuacaoMedia2 = media2.orElse(0.0);

		Optional<Usuario> max = usuarios
			.stream()
			.max(Comparator.comparingInt(Usuario::getPontos));

		Optional<String> maxNome = usuarios
			.stream()
			.max(Comparator.comparingInt(Usuario::getPontos))
			.map(u -> u.getNome());


	}
}
