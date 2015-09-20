package br.com.danese;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.danese.chainofresponsibility.conta.Conta;
import br.com.danese.chainofresponsibility.conta.Filtro;
import br.com.danese.chainofresponsibility.conta.FiltroMaiorQue500MilReais;
import br.com.danese.chainofresponsibility.conta.FiltroMenorQue100Reais;
import br.com.danese.chainofresponsibility.conta.FiltroMesmoMes;

public class TestaDecoretorDeContas {

	public static void main(String[] args) {
		
		ArrayList<Conta> contas = new ArrayList<Conta>();
		
		contas.add(new Conta("Mario", LocalDate.of(1987, 2, 23), 90));
		contas.add(new Conta("Adao", LocalDate.of(1987, 2, 23), 230));
		contas.add(new Conta("Antonio", LocalDate.of(1987, 2, 23), 850));
		contas.add(new Conta("Maria", LocalDate.of(2015, 9, 13), 100));
		contas.add(new Conta("José", LocalDate.of(1987, 2, 23), 200));
		contas.add(new Conta("Fabio", LocalDate.of(1987, 2, 23), 450));
		
		Filtro filtro = new FiltroMesmoMes(new FiltroMenorQue100Reais(new FiltroMaiorQue500MilReais()));
		List<Conta> contasFiltradas = filtro.filtra(contas);
		
		contasFiltradas.forEach(System.out::println);
		
	}
	
}
