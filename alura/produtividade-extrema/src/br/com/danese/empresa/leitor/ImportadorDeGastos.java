package br.com.danese.empresa.leitor;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import br.com.danese.empresa.modelo.Funcionario;
import br.com.danese.empresa.modelo.Gasto;

public class ImportadorDeGastos {
	
	private SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

	public Collection<Gasto> importa(InputStream entrada) throws ParseException {
		Scanner leitor = new Scanner(entrada);
		Set<Gasto> gastos = new LinkedHashSet<>() ;
		while (leitor.hasNextLine()) {
			String line = leitor.nextLine();
			String tipoTxt = line.substring(0, 6);
			String dataTxt = line.substring(6, 14);
			String valorTxt = line.substring(14, 23);
			String matriculaTxt = line.substring(23, 26);
			String nome = line.substring(26, 56);
			String dataNascTxt = line.substring(56);
			
			double valor = Double.parseDouble(valorTxt);
			int matricula = Integer.parseInt(matriculaTxt);
			
			Calendar dataNascimento = getDataCalendarDeTxt(dataNascTxt);
			
			Calendar dataDespesa = getDataCalendarDeTxt(dataTxt);
			
			addFuncionario(gastos, tipoTxt, nome, valor, matricula, dataNascimento, dataDespesa);
		}
		leitor.close();
		return gastos;
	}

	private void addFuncionario(Collection<Gasto> gastos, String tipoTxt, String nome, double valor, int matricula,
			Calendar dataNascimento, Calendar dataDespesa) {
		Funcionario funcionario = new Funcionario(nome, matricula, dataNascimento);
		gastos.add(new Gasto(valor, tipoTxt, funcionario, dataDespesa));
	}

	private Calendar getDataCalendarDeTxt(String dataTxt) throws ParseException {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(df.parse(dataTxt));
		return dataNascimento;
	}
}
