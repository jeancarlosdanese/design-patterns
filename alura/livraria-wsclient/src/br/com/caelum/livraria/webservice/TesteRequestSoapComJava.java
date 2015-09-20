package br.com.caelum.livraria.webservice;

import java.rmi.RemoteException;

public class TesteRequestSoapComJava {

	public static void main(String[] args) throws RemoteException {
		
		LivrariaWS livraria = new LivrariaWSProxy();
		
		Livro[] livros = livraria.getLivrosPorTitulo("a");
		
		for (Livro livro : livros) {
			System.out.println(livro.getTitulo() + ", Autor: " + livro.getAutor().getNome());
		}
		
	}
	
}
