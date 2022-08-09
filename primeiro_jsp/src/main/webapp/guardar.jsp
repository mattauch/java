<%@page import="java.util.Date"%>
<%@page import="com.softgraf.dao.ContatoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- Instancia um objeto contato
 scope = "page|session|request|application"
 scope padrão = "page"
--%>
<jsp:useBean id="contato" class="com.softgraf.dao.Contato" />
<jsp:useBean id="dao" scope="session"
	class="com.softgraf.dao.ContatoDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guarda Parâmetros</title>
</head>
<body>
	<%--
 Para remover um pouco do código java na página JSP
 a Sun criou uma linguagem chamada Expression Language
 --%>
	<h3>Mostrando parâmetros recebidos:</h3>
	ID: ${param.id}
	<br> Nome: ${param.nome}
	<br> Fone: ${param.fone}
	<br> Email: ${param.email}
	<br>
	<br>

	<%
	Integer id = Integer.parseInt(request.getParameter("id"));
	String nome = request.getParameter("nome");
	String fone = request.getParameter("fone");
	String email = request.getParameter("email");

	// objeto instanciado via <use:bean .../>
	contato.setId(id);
	contato.setNome(nome);
	contato.setFone(fone);
	contato.setEmail(email);
	contato.setData(new Date());

	dao.addContato(contato);

	out.println("<h3>Total de contatos existentes no dao: " + dao.getLista().size() + "</h3>");
	%>

	<h3>Exemplos Expression Language:</h3>
	${5 >= 4}
	<br> ${1 > (4/2)}
	<br> ${100.0 == 100}
	<br> ${10 mod 4}
	<br> ${empty param.sobrenome}
	<br> ${header["host"]}
	<br> ${pageContext.request.contextPath}
	<br>
	<br>

	<a href="taglibs.jsp">Exemplo Taglibs</a>
</body>
</html>
