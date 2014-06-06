<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
    
    <c:if test="${mensagem != null}">
        <div>${mensagem}</div>
    </c:if>
    
    <form action="${path}/login" method="post">
        <div>
            <label for="email">E-mail</label>
            <input type="text" name="email" id="email" />
        </div>
        <div>
            <label for="senha">Senha</label>
            <input type="password" name=senha id="senha" />
        </div>
        <div>
            <button type="submit">Entrar</button>
            <button type="reset" >Limpar</button>
        </div>
    </form>
    
</body>
</html>