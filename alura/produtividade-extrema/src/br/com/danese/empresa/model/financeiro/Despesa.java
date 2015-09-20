package br.com.danese.empresa.model.financeiro;

import java.util.List;

import br.com.danese.empresa.model.produto.Produto;

public class Despesa {
	private List<Produto> produtosRepostos;
	private double valorDaCompra;
	private String cnpjFornecedor;
	
	public Despesa(List<Produto> produtosRepostos, double valorDaCompra, String cnpjFornecedor) {
		this.produtosRepostos = produtosRepostos;
		this.valorDaCompra = valorDaCompra;
		this.cnpjFornecedor = cnpjFornecedor;
	}

	public List<Produto> getProdutosRepostos() {
		return produtosRepostos;
	}

	public double getValorDaCompra() {
		return valorDaCompra;
	}

	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}
	
	
}
