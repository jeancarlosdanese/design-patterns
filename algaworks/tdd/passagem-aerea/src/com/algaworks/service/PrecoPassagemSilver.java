package com.algaworks.service;

import com.algaworks.model.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {

	@Override
	public double calcular(Voo voo) {
		if (voo.getPrecoPassagem() > 700)
			return voo.getPrecoPassagem() * 0.9;

		return voo.getPrecoPassagem() * 0.94;
	}

}
