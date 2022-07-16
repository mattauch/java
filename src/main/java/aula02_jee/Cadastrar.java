package aula02_jee;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	public void init(ServletConfig config) throws ServletException {
		
	}

	
	public ServletConfig getServletConfig() {
		
		return null;
	}

	
	public String getServletInfo() {
		
		return null; 
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		String id= req.getParameter("id");
		String nome= req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");
		String sexo = req.getParameter("radioSexo");
		String checkJava = req.getParameter("checkJava") == null ? "" : "J";
		String checkPython = req.getParameter("checkPython" == null ? "" : "Y");
		String checkPhp = req.getParameter("checkPhp" == null ? "" : "P");
		String checkSQL = req.getParameter("checkSQL" == null ? "" : "S");
		String linguagens = checkJava +  checkPython + checkPhp +  checkSQL;
		String cidade = req.getParameter("radioCidade");
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset= 'utf-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Servelet recebeu formulário</h3>");
		
		out.println("<br> ID: " +id);
		out.println("<br> Nome: " +nome);
		out.println("<br> Sobrenome: " +sobrenome);
		out.println("<br> Sexo " +sexo);
		out.print("<br> Linguagens: " + linguagens);
		out.println("<br> Cidade: " + cidade);
		
		out.println("</body>");
		out.println("</html>");
		
		salvarDados(nome, sobrenome, sexo, linguagens, cidade);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private boolean salvarDados (String nome, String sobrenome, String sexo, String linguagens, String cidade) {
		 String urlConexao = "jdbc:mysql://localhost:3306/emprego?useSSL=false&useTimezone=true&serverTimezone=UTC";
		 String usuario = "root";
		 String senha = "softgraf";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(urlConexao, usuario, senha);
			
			PreparedStatement cmd = conexao.prepareStatement("insert into candidato(nome, sobrenome, sexo, linguagem, cidade)" + "values (?, ?, ?, ?, ?)");
			cmd.setString(1, nome);
			cmd.setString(2, sobrenome);
			cmd.setString(3, sexo);
			cmd.setString(4, linguagens);
			cmd.setString(5, cidade);
			
			int retorno = cmd.executeUpdate();
			conexao.close();
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return false;
		
	}

}
