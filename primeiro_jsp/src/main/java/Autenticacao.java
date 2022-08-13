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
		
		//obtém a sessão atual ou null
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);  //tenta ler a sessão e se ela não exisir ela não cria a sessão
		
		if(session != null && session.getAttribute("login") != null) {
		System.out.println("Você já está logando");
		chain.doFilter(request, response);
		
		//significa que o usuário nã está logado
		} else if (nome != null && nome.equalsIgnoreCase("Amanda") && senha != null && senha.equals("1234")) {
			//cria a sessão
			session =req.getSession(true); //obtém a sessão
			//salva o login na sessão
			session.setAttribute("login", nome);
			//carrega a página solicitada
			chain.doFilter(request, response);
		} else {
			//não está logado e não foi informado login e senha
			//faz o incaminhamento para o login
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		System.out.println("=============doFilter() finalizado");
		
	}
	
	

}
