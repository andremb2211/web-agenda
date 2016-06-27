package br.com.nucleoz.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.nucleoz.entidades.Contato;
import br.com.nulceoz.factory.ConnectionFactory;

public class ContatoDao {

	private Connection connection;

	// construtor padrao
	public ContatoDao() {
		this.connection = ConnectionFactory.getInstance().getconnection();
		/*
		 * quando o objeto do contato dao for chamado ira ser aberto ja uma
		 * conexao
		 */
	}

	public void adicionaContato(Contato contato) {

		String sql = "insert into contatos" + "(nome,email,endereco, dataNascimento)" + "values (?,?,?,?)";

		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getEmail());
			preparedStatement.setString(3, contato.getEndereco());

			Date data = new Date(Calendar.getInstance().getTimeInMillis());

			preparedStatement.setDate(4, data);

			preparedStatement.execute();

			System.out.println("Conexao bem sucedida!");

		} catch (SQLException e) {
			System.out.println("Erro de conexão!");
			e.printStackTrace();
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				System.out.println("Nao conseguir fechar a conexao!");
				e.printStackTrace();
			}
		}

	}

	public List<Contato> retornaTodosContatos(){
		
		List<Contato> listacontatos = new ArrayList<Contato>();
		
		String sql = "Select * from contatos";
		PreparedStatement preparedStatement;

		try {
			preparedStatement = this.connection.prepareStatement(sql);

			// Executa operações de SQL
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
			}

		} catch (SQLException e) {
			System.out.println("Não houve resultados!");
			e.printStackTrace();

			return listacontatos;

		}
		return listacontatos;
	}

}