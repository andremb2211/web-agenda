package br.com.nucleoz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nucleoz.dao.ContatoDao;
import br.com.nucleoz.entidades.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 5007562466920880972L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter(); // manda os dados

		String nome, endereco, email, dataEmTexto;

		nome = request.getParameter("nome");
		endereco = request.getParameter("endereco");
		email = request.getParameter("email");
		dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		/*
		 * usando a classe contato.class para obter o dados e gravar no banco
		 * 
		 * é necessario gerar um jar do projeto e add a bibliotecas
		 * 
		 */

        //Realiza o tratamento 
		try {
			Date date = new SimpleDateFormat("dd/mm/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);

		} catch (ParseException e) {
			System.out.println("Erro de conversão de data!");
		}

		//Cria o objeto contato
		Contato contato = new Contato(nome, email, endereco, dataNascimento);
        ContatoDao contatoDao = new ContatoDao();
        
        contatoDao.adicionaContato(contato);
        
		
		//Mostra na tela 
		out.println("<html>");
		out.println("<body>");
		out.println("<p>");
		out.println("Contato"+contato.getNome()+"Adicionado!");
		/*out.println(contato.getEmail());
		out.println(contato.getEndereco());
		out.println(contato.getDataNascimento());*/
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");

	}

}
