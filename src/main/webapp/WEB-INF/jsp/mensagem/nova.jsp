<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Mensagem</title>
</head>
<body>
    <c:if test="${mensagem != null}">
        <div>${mensagem}</div>
    </c:if>
    <form action="${path}/mensagem/nova" method="post">
        <div>
            <label for="corpo">
                Mensagem:
            </label>
            <textarea id="corpo" name="corpo" rows="2" cols="40"></textarea>
        </div>
        <div>
            <input type="submit" value="Postar"/>
            <input type="reset" value="Limpar"/>
        </div>
    </form>
</body>
</html>
