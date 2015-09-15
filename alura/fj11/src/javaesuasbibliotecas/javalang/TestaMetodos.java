package javaesuasbibliotecas.javalang;

import javaesuasbibliotecas.pacotes.banco.conta.Conta;
import javaesuasbibliotecas.pacotes.banco.conta.ContaCorrente;

public class TestaMetodos {
	public static void main(String[] args) {
		Conta conta = new ContaCorrente(10, "Mario");
		System.out.println(conta);
		
		Conta conta1 = new ContaCorrente(10, "Mario");
		System.out.println(conta1);
		
		if(conta == conta1) {
			System.out.println("São iguais");
		} else {
			System.out.println("São diferentes");
		}
		
		if(conta.equals(conta1)) {
			System.out.println("São iguais");
		} else {
			System.out.println("São diferentes");
		}
		
	}
}
