package com.algaworks.tdd.repository;

import com.algaworks.tdd.model.Pedido;
import com.algaworks.tdd.service.AcaoLancamentoPedido;

public class Pedidos implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Salvando no banco de dados...");
	}
	
	public Pedido buscarPeloPedido(Long codigo) {
		// Ele iria buscar no banco de dados pelo código
		return new Pedido();
	}
	
}
