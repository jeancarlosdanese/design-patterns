package br.com.danese.empresa.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestaGasto {
	public static void main(String[] args) {
		Calendar dataNascimento = new GregorianCalendar(1974, 01, 27);
		Funcionario funcionario = new Funcionario("José", 123, dataNascimento );
		Calendar hoje = Calendar.getInstance();
		
		Gasto gasto1 = new Gasto(45.5, "taxi", funcionario, hoje);
		Gasto gasto2 = new Gasto(45.5, "taxi", funcionario, hoje);
		Gasto gasto3 = new Gasto(45.5, "taxi", funcionario, hoje);
		
		System.out.println(gasto1);
		System.out.println(gasto2);
		System.out.println(gasto3);
	}
}
