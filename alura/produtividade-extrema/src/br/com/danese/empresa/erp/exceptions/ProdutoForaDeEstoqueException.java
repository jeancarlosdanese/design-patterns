package br.com.danese.empresa.erp.exceptions;

import br.com.danese.empresa.model.produto.Produto;

public class ProdutoForaDeEstoqueException extends RuntimeException {

	private static final long serialVersionUID = -6200914212377863370L;

	public ProdutoForaDeEstoqueException(Produto produto) {
		super("Não há estoque de: " + produto.getNome());
	}

}
