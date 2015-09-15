package br.com.danese.jdbc.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.danese.jdbc.ConnectionPool;
import br.com.danese.jdbc.dao.ProdutosDAO;

public class TestaInsercaoDeProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Mesa Vermelha", "Mesa com 3 pés");

		try (Connection conn = new ConnectionPool().getConnection()) {
			ProdutosDAO dao = new ProdutosDAO(conn);
			dao.salva(produto);
			List<Produto> produtos = dao.lista();
			for (Produto p : produtos) {
				System.out.println(p);
			}
		}

	}

}
