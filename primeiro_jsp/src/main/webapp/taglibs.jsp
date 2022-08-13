<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="dao" scope="session" class="com.softgraf.dao.ContatoDAO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>taglibs JSTL</title>
</head>
<body>

	<c:import url="cabecalho.jsp"/>
	<c:set var="total" scope="page" value="${dao.lista.size()}"/>
	
	
	Total: <c:out value="${total}"/>

	<h3>JSTL - Java Server Pages Standard Tag Library</h3>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Fone</th>
			<th>E-mail</th>
			<th>Data</th>
		</tr>
		
		<c:forEach var="contato" items="${dao.lista}">
		
			<tr>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<td>${contato.fone}</td>
				
				<td>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					<c:if test="${empty contato.email}">
						E-mail n�o informado
					</c:if>
				</td>
				
				<td>
					<c:choose>
						<c:when test="${not empty contato.data}">
							<fmt:formatDate value="${contato.data}" pattern="dd/MM/yyyy"/>
						</c:when>
						
						<c:otherwise>
							Data n�o informada
						</c:otherwise>
					
					</c:choose>
					
				</td>
					
			</tr>
			
		</c:forEach>
	
	</table>
	
	<h4>Antes de remover: total = <c:out value = "${total}"/></h4>
	<c:remove var="total"/>
	<h4>Depois de remover: total = <c:out value = "${total}"/></h4>
	
	<c:url var="destino" value="index.jsp">
	<c:param name="origem" value="taglibs.jsp"/>
	</c:url>
	
	<a href="${destino}">P�gina Principal</a>
	
	
	
	<%-- Inclus�o de conte�do usando:
		- <jsp:incliude ...>
		somente p�ginas da aplica��o
		
		- <c:import ...>
		p�ginas da aplica��o e p�ginas externas
	 --%>
	
	<c:import url = "rodape.jsp" charEncoding="ISO-8859-1" /> 

</body>
</html>