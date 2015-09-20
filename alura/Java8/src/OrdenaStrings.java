import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do código");
		palavras.add("caelum");

		/*
		 * Collections.sort(palavras, new Comparator<String>() {
		 * 
		 * @Override public int compare(String s1, String s2) { if (s1.length()
		 * < s2.length()) return -1; if (s1.length() > s2.length()) return 1;
		 * return 0; } });
		 */

		/*
		 * palavras.sort(new Comparator<String>() {
		 * 
		 * @Override public int compare(String s1, String s2) { if (s1.length()
		 * < s2.length()) return -1; if (s1.length() > s2.length()) return 1;
		 * return 0; } });
		 */

		/*palavras.sort((String s1, String s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});*/

		/*palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});*/

//		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

//		palavras.sort(Comparator.comparing(s -> s.length()));

		palavras.sort(Comparator.comparing(String::length));

//		palavras.sort(String.CASE_INSENSITIVE_ORDER);

		/*
		 * palavras.forEach(new Consumer<String>(){
		 * 
		 * @Override public void accept(String palavra) {
		 * System.out.println(palavra); } });
		 */

		/*
		 * palavras.forEach((String palavra) -> { System.out.println(palavra);
		 * });
		 */

//		palavras.forEach(palavra -> System.out.println(palavra));
		
		palavras.forEach(System.out::println);
		
		new Thread(() ->  System.out.println("Executando um Runnable")).start();
		
	}

}
