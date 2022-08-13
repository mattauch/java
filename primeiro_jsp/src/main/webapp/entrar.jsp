<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Envia Par�metros</title>
</head>
<body>

	<%-- inclus�o din�mica de p�gina --%>
	<jsp:include page="cabecalho.jsp" flush="true">
		<jsp:param name="titulo" value="Entrada de Parametros"/>
	</jsp:include>
	
	<form action="guardar.jsp" method="get">
	
		Id: <input type="text" name="id"><br>
		Nome: <input type="text" name="nome"><br>
		Fone: <input type="text" name="fone"><br>
		Email: <input type="text" name="email"><br><br>
		
		<button type="submit">Guardar</button>
	</form>

</body>
</html>