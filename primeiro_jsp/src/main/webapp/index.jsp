
<%@page import="com.softgraf.dao.Contato"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%--
	Instancia um objeto ContatoDAO
	         menor escopo         maior escopo
	scope = "request|page|session|application"
	scope padr�o = "page"
 --%>
<jsp:useBean id="dao" scope="session" class="com.softgraf.dao.ContatoDAO"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeiro JSP</title>
</head>
<body>

	<%@ include file="cabecalho.jsp" %>

	Bem vindo <% out.println("Amanda");  %> � p�gina principal<br>
	
	<%-- coment�rio jsp: abaixo � uma declara��o JSP --%>
	<%! public final double PI = 3.14; %>
	
	<!-- coment�rio html: abaixo � um scriplet -->
	<%
		String mensagem = "Este � um scriptlet";
		String exp = "Exemplo de express�o ou atalho";
	%>
	
	<% out.println(mensagem); %><br>
	<% System.out.println("Essa mensagem de scriptlet sai apenas no console"); %><br>
	
	<%= exp %><br>
	Valor de pi = <%= PI %><br><br>
	
	<ul>
	
	<%
		List<Contato> contatos = dao.getLista();
		for (Contato c: contatos){
	%>	
			<li><%= c.getId() %> | <%= c.getNome() %> | <%= c.getFone() %> | <%= c.getEmail() %></li>
	<%
		}
	%>
	
	</ul>
	
	<h4>Par�metro origem = ${param.origem}</h4>
	
	<br>
	<a href="entrar.jsp">Editar Parametros</a> <br>
	<a href="taglibs.jsp">Exemplo Taglibs</a> <br>
	<a href="index.jsp?logout">Logout</a>
	
	<%
		if (request.getParameter("logout") != null){
			session.invalidate();
			response.sendRedirect("index");
		}
	
	%>
	
	
	<%@ include file="rodape.jsp" %>

</body>
</html>