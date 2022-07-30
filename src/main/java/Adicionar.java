

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/adicionar")
public class Adicionar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cookieNome = req.getParameter("cookienome");
		String cookieValor = req.getParameter("cookievalor"); //getParameter - serve apenas para String
		int cookieTempo = Integer.parseInt(req.getParameter("cookietempo"));
		
		Cookie cookie = new Cookie(cookieNome, cookieValor);
		//tempo de vida do cookie
		//-1= dura at� o navegador ser fechado (padr�o do sistema)
		//0= apaga o cookie
		//>0= dura��o do cookie em segundos
		cookie.setMaxAge(cookieTempo);
		
		resp.addCookie(cookie);
		
		resp.setContentType("text/html"); //tipo MIME
		PrintWriter out = resp.getWriter();
		out.append("<html>" +
		
					"<head><title>Cookies</title></head>" +
					
					"<body>" +
					
					"<h3>Cookie adicionado</h3>" +
					"Nome: " + cookie.getName() + "<br>" +
					"Valor: " + cookie.getValue() + "<br>" +
					"Tempo: " + cookie.getMaxAge() + "<br>" +
					"<br>" +
					
					"<a href='/projeto_cookies/'>Adicionar Cookies</a><br>" +
					"<a href='/projeto_cookies/listar'>Listar Cookies</a><br>" + 
					
					"</body>" +
					
				"</html>"
				
				);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
