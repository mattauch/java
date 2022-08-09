<!-- Usar Tomcat 9 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.softgraf.dao.Contato"%>
<%@ page import="java.util.List"%>
<%-- Instancia um objeto ContatoDAO
 scope = "page|session|request|application"
 scope padrão = "page"
--%>
<jsp:useBean id="dao" scope="session"
	class="com.softgraf.dao.ContatoDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeiro JSP</title>
</head>
<body>
	<%-- inclusão estática do logo --%>
	<%@ include file="cabecalho.jsp"%>

	Bem vindo
	<%=session.getAttribute("login")%>
	à página principal
	<br>

	<%-- comentário: esta é uma declaração JSP --%>
	<%!public final double pi = 3.14;%>
	<%-- comentário: este é um scriptlet --%>
	<%
	String mensagem = "Este é um scriptlet";
	String exp = "Exemplo de expressão ou atalho";
	%>
	<%
	out.println(mensagem);
	%><br>

	<%
	System.out.println("Essa mensagem de scriptlet sai apenas no console");
	%><br>

	<%=exp%><br>


	<ul>

		<%
		List<Contato> contatos = dao.getLista();
		for (Contato c : contatos) {
		%>

		<li><%=c.getId()%> | <%=c.getNome()%> | <%=c.getFone()%> | <%=c.getEmail()%>
		</li>
		<%
		}
		%>

	</ul>

	<%
	session.setAttribute("dao", dao);
	out.println("<br>dao salvo na sessão corrente<br>");
	%>

	<!-- Expression Language aqui -->
	<h4>origem: ${param.origem}</h4>

	<a href="entrar.jsp">Entrar Parâmetros</a>
	<br>
	<a href="taglibs.jsp">Exemplo Taglibs</a>
	<br>
	<a href="index.jsp?logout">Logout</a>

	<%
	if (request.getParameter("logout") != null) {
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	%>
</body>
</html>