<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>
<body>
	
	<form action="cadastro" method="post">
	
	<div>
		<label > ${msg}</label>
	</div>	
		
		
	<div>	
		<label for="nickname">Nickname:</label>
		<input id="nickname" name="nickname"/>
	</div>
	
	<div>	
		<label for="email">Email:</label>
		<input id="email" name="email"/>
	</div>
	
	<div>	
		<label for="senha">Senha:</label>
		<input id="senha" name="senha"/>
	</div>
	
	<div>	
		<label for="confirmaSenha">Confirmar Senha:</label>
		<input id="confirmaSenha" name="confirmaSenha"/>
	</div>
	
	<div>	
		<input type = "submit" value = "Cadastrar"/>
	</div>
		
	</form>
	
</body>
</html>