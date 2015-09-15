package br.com.danese.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionPool().getConnection()) {
			connection.setAutoCommit(false);
			
			
			String sql = "insert into Produto (nome, descricao) values (?, ?)";
			try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				adiciona("TV LCD", "32 polegadas", stmt);
				adiciona("Blueray", "Full HDMI", stmt);
				
				connection.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("rollback efetuado");
			}
		}

	}

	private static void adiciona(String nome, String descricao, PreparedStatement stmt) throws SQLException {
		/*if (nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}*/

		stmt.setString(1, nome);
		stmt.setString(2, descricao);
		boolean resultado = stmt.execute();

		System.out.println(resultado);

		try (ResultSet resultSet = stmt.getGeneratedKeys()) {
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				System.out.println(id + " gerado");
			}
		}
	}
}
