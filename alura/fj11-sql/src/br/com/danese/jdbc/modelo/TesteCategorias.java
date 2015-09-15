package br.com.danese.jdbc.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.danese.jdbc.ConnectionPool;
import br.com.danese.jdbc.dao.CategoriasDAO;

public class TesteCategorias {

	public static void main(String[] args) throws SQLException {
		try (Connection conn = new ConnectionPool().getConnection()) {

			List<Categoria> categorias = new CategoriasDAO(conn).listaComProdutos();
			for (Categoria categoria : categorias) {
				System.out.println(categoria.getNome());
				for (Produto produto : categoria.getProdutos()) {
					System.out.println(categoria.getNome() + " - " + produto.getNome());
				}
			}
		}
	}

}
