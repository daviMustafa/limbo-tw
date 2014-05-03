<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	
<form method="post" action="buscar">	
	
	
	<label>Filtro Busca:</label>
	<input id="filtro" value ="${filtro}" name = "filtro"/>
	<button type = "submit">Buscar</button>
	
</form>


<c:if test="${empty usuarios}">Nenhum usuário encontrado</c:if>
	<c:forEach var="usuario" items="${usuarios}">
		<label>Nickname: </label> ${usuario.nickname}
		<label>Email: </label> ${usuario.email}
	</c:forEach>
</body>
</html>