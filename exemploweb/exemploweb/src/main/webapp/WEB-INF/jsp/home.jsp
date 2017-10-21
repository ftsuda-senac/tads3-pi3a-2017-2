<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <c:import url="/WEB-INF/jsp/cabecalho.jsp" />
    <h1>Home page</h1>

    <ul>
      <li>Opcao 1</li>
      <li>Opcao 2</li>
	<c:if test="${sessionScope.usuario.temPapel('ADMIN')}">
	<li><a href="${pageContext.request.contextPath}/cadastro-produto">Cadastrar produto</a></li>
	</c:if>
	<c:if test="${sessionScope.usuario.temPapel('GOD')}">
	<li>Só os fodões veem este texto</li>
	</c:if>
    </ul>

  </body>
</html>
