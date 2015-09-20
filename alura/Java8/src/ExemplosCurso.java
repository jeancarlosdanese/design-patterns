import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Curso {
	private final String nome;
	private final int alunos;

	public Curso(String nome, int alunos) {
		super();
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
	
	@Override
	public String toString() {
		return nome + " - " + alunos;
	}

}

public class ExemplosCurso {
	public static void main(String[] args) {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
//		cursos.forEach(System.out::println);
//		cursos.forEach(c -> System.out.println(c.getNome() + " - " + c.getAlunos()));
		
		// Imprimir todos os cursos c/ mais de 100 alunos
		
		System.out.println("=======================================================");

		cursos.stream()
				.filter(c -> c.getAlunos() >= 50)
				.forEach(c -> System.out.println(c.getNome()));
	
		System.out.println("\n=======================================================");
		
		/*cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.map(c -> c.getAlunos())
				.forEach(total -> System.out.println(total));*/
		
		cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.map(Curso::getAlunos)
				.forEach(System.out::println);
		
		System.out.println("\n=======================================================");
		
		Stream<String> nomes = cursos.stream()
				.filter(c -> c.getAlunos() >= 50)
				.map(Curso::getNome);
		
		nomes.forEach(System.out::println);
		
		System.out.println("\n=======================================================");
		
		int sum = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos)
				.sum();
		System.out.println(sum);

		System.out.println("\n=======================================================");
		
		cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.findAny()
				.ifPresent(System.out::println);

		System.out.println("\n=======================================================");
		
		OptionalDouble media = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos)
				.average();

		media.ifPresent(System.out::println);
	
		System.out.println("\n=======================================================");

		List<Curso> cursos2 = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
		
		cursos2.forEach(System.out::println);
	
		System.out.println("\n=======================================================");

		cursos = (ArrayList<Curso>) cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
		
		cursos.forEach(System.out::println);
		
		System.out.println("\n=======================================================");

		Map<String, Integer> map = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(),
					c -> c.getAlunos()));
		
		System.out.println(map);
		
		System.out.println("\n=======================================================");

		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(),
					c -> c.getAlunos()))
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
		System.out.println("\n=======================================================");

		cursos.parallelStream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(),
					c -> c.getAlunos()))
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
	
	}
}