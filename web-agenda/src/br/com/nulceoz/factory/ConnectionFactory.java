package br.com.nulceoz.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory instance;

	public static ConnectionFactory getInstance() {

		if (instance == null) {
			inicializaInstancia();

		}
		return instance;
	}

	private static synchronized void inicializaInstancia() { // garante que um usuario nao utilize a instancia de outro 
		if (instance == null) {
			instance = new ConnectionFactory();

		}
	}

	/**
	 * @since 23/06/16
	 * @return  a conexao do banco 
	 * 
	 */
	
	public Connection getconnection() {
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/web", "root", "nucleoz");
			System.out.println("Conectado ao banco!");
			return conexao;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e); // lança uma exceção em tempo de
											// execução
		}

	}

}
