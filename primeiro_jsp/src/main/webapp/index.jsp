<!-- Usar Tomcat 9 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.softgraf.dao.Contato"%>
<%@ page import="java.util.List"%>
<%-- Instancia um objeto ContatoDAO
 scope = "page|session|request|application"
 scope padr�o = "page"
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
	<%-- inclus�o est�tica do logo --%>
	<%@ include file="cabecalho.jsp"%>

	Bem vindo
	<%=session.getAttribute("login")%>
	� p�gina principal
	<br>

	<%-- coment�rio: esta � uma declara��o JSP --%>
	<%!public final double pi = 3.14;%>
	<%-- coment�rio: este � um scriptlet --%>
	<%
	String mensagem = "Este � um scriptlet";
	String exp = "Exemplo de express�o ou atalho";
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
	out.println("<br>dao salvo na sess�o corrente<br>");
	%>

	<!-- Expression Language aqui -->
	<h4>origem: ${param.origem}</h4>

	<a href="entrar.jsp">Entrar Par�metros</a>
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