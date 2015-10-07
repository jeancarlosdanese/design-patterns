package com.algaworks.curso.jpa2;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;

@Named
@ViewScoped
public class RelatorioTotalAlgueisPorCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroDAO carroDAO;
	
	private List<TotalDeAlugueisPorCarro> totalDeAlugueisPorCarro;
	
	public void buscar() {
		totalDeAlugueisPorCarro = this.carroDAO.buscarTotalAlugueisPorCarro();
	}

	public List<TotalDeAlugueisPorCarro> getTotalDeAlugueisPorCarro() {
		return totalDeAlugueisPorCarro;
	}
	
}