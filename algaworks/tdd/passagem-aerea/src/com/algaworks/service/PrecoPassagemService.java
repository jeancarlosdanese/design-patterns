package com.algaworks.service;

import com.algaworks.model.Passageiro;
import com.algaworks.model.Voo;

public class PrecoPassagemService {

	public double calcular(Passageiro passageiro, Voo voo) {
		/*if (passageiro.getTipo().equals(TipoPassageiro.GOLD)) {
			if (voo.getPrecoPassagem() > 500) {
				return voo.getPrecoPassagem() * 0.85;
			} else {
				return voo.getPrecoPassagem() * 0.9;
			}
		} else if (passageiro.getTipo().equals(TipoPassageiro.SILVER)) {
			if (voo.getPrecoPassagem() > 700) {
				return voo.getPrecoPassagem() * 0.9;
			} else {
				return voo.getPrecoPassagem() * 0.94;
			}
		}*/

//		throw new TipoPassageiroInvalidoException();
		
		return passageiro.getTipo().getCalculadora().calcular(voo);
	}

}
