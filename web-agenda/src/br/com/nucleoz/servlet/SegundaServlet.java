package br.com.nucleoz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "segundaServlet", urlPatterns="/ola") /* da o nome da servlet e faz o mapping*/
public class SegundaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8297167601138169429L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("Segunda Servlet");
		out.println("</h1>");
		out.println("<p>");
		out.println("<p>");
		out.println("CARNE DE SOL");
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	
	
}
