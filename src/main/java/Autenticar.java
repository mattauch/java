
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Obt�m a sess�o corrente ou null
		HttpSession session = req.getSession(false);

		// recupera login e senha enviados pela tela de login
		String nome = req.getParameter("nome");
		String senha = req.getParameter("senha");

		// se j� estiver logado
		if (session != null && session.getAttribute("login") != null) {
			// vai para a p�gina principal
			req.getRequestDispatcher("/index").forward(req, resp);
			// se n�o est� logado, verifica se o nome e senha est�o corretos
		} else if (nome != null && senha != null && nome.equalsIgnoreCase("Amanda") && senha.equals("1234")) {

			// se a senha est� correta ent�o cria a sess�o e salva o usu�rio
			session = req.getSession(true);

			// salva o usu�rio na senha
			session.setAttribute("login", nome);

			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.append("<html>" +
						"<head><title>Logado</title></head>" +
						"<body>" +
						"<h2>Nova sess�o criada</h2>" +
						"<h3>Session ID: " + session.getId() + "</h3>" +
						"<h3>Session Creation Time: " + new Date(session.getCreationTime()) + "</h3>" +
						"<h3>Session Last Accessed Time: " + new Date(session.getLastAccessedTime()) + "</h3>" +
						"<h3>Session Max Inactive Interval: " + new Date(session.getMaxInactiveInterval()) + "</h3>" +
						"<a href='" + req.getContextPath() + "/index.html'>Continuar</a>" +
						"</body>" +
						"</html>"
					);
		} else {
			resp.sendRedirect(req.getContextPath() + "/tela_login.html");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
