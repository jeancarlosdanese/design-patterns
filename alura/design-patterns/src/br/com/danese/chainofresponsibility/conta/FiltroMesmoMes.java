package br.com.danese.chainofresponsibility.conta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FiltroMesmoMes extends Filtro {

	public FiltroMesmoMes() {
		super();
	}

	public FiltroMesmoMes(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		for (Conta c : contas) {
			if (c.getDataAbertura().getMonth().equals(LocalDate.now().getMonth())
					&& c.getDataAbertura().getYear() == LocalDate.now().getYear()) {
				filtrada.add(c);
			}
		}
		filtrada.addAll(proximo(contas));
		return filtrada;
	}
}