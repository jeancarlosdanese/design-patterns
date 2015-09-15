package br.com.danese.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private Integer id;
	private final String nome;
	private final List<Produto> produtos = new ArrayList<Produto>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void adiciona(Produto produto) {
		produtos.add(produto);
	}
	
}
