import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (urlPatterns = {"/index"})
@WebFilter (urlPatterns= {"/*"})
public class Autenticacao extends HttpServlet implements Filter {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("chamou /index da servlet");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("=============doFilter() iniciado");
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		//obt�m a sess�o atual ou null
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);  //tenta ler a sess�o e se ela n�o exisir ela n�o cria a sess�o
		
		if(session != null && session.getAttribute("login") != null) {
		System.out.println("Voc� j� est� logando");
		chain.doFilter(request, response);
		
		//significa que o usu�rio n� est� logado
		} else if (nome != null && nome.equalsIgnoreCase("Amanda") && senha != null && senha.equals("1234")) {
			//cria a sess�o
			session =req.getSession(true); //obt�m a sess�o
			//salva o login na sess�o
			session.setAttribute("login", nome);
			//carrega a p�gina solicitada
			chain.doFilter(request, response);
		} else {
			//n�o est� logado e n�o foi informado login e senha
			//faz o incaminhamento para o login
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		System.out.println("=============doFilter() finalizado");
		
	}
	
	

}
