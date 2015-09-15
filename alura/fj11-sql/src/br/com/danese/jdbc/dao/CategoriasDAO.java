package br.com.danese.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.danese.jdbc.modelo.Categoria;
import br.com.danese.jdbc.modelo.Produto;

public class CategoriasDAO {

	private final Connection conn;
	private final List<Produto> produtos = new ArrayList<>();

	public CategoriasDAO(Connection conn) {
		this.conn = conn;
	}

	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();

		String sql = "select * from Categoria";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					Categoria categoria = new Categoria(id, nome);
					categoria.setId(id);
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	public List<Categoria> listaComProdutos() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		Categoria ultima = null;
		
		/*String sql = "select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, "
				+ "p.descricao as p_descricao from Categoria as c join Produto as p on p.categoria_id = c.id";*/
		
		String sql = "select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, "
				+ "p.descricao as p_descricao from Categoria as c join Produto as p on p.categoria_id = c.id order by c.id";
		
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("c_id");
					String nome = rs.getString("c_nome");
					if(ultima==null || !ultima.getNome().equals(nome)) {
                        Categoria categoria = new Categoria(id, nome);
                        categorias.add(categoria);
                        ultima = categoria;
                    } 
					int idDoProduto = rs.getInt("p_id");
					String nomeDoProduto = rs.getString("p_nome");
					String descricaoDoProduto = rs.getString("p_descricao");
					Produto produto = new Produto(nomeDoProduto, descricaoDoProduto);
					produto.setId(idDoProduto);
					ultima.adiciona(produto);
				}
			}
		}
		return categorias;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	
	
}
