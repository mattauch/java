package aula01_jee;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/processar")
public class PrimeiraServlet extends HttpServlet {

	// main da servlet - servidorzinho de web
	// req = requesição - entrada
	// resp = responder - saída
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//passa as variáveis na barra de pesquisa de cima do browser
		PrintWriter out = resp.getWriter();
		String nome = req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");
		out.print("<h1>Nome: " + nome + "</h1>");
		out.print("<h1>Sobrenome: " + sobrenome + "</h1>");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//forma mais segura
		doGet(req, resp);
	}

}
