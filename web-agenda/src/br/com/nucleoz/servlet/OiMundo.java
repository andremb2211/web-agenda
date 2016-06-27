package br.com.nucleoz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet { /**
	 * 
	 */
	private static final long serialVersionUID = -3683799440977177674L;

/* para uso da servelet é necessario extender da httpservlet*/
											 

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("Primeira Servlet");
		out.println("</h1>");
		out.println("<p>");
		out.println("<p>");
		out.println("PUDIM DE LEITE");
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
