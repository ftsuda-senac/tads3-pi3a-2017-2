<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Produtos</h1>
    <c:forEach items="${produtos}" var="prod">
      <div>
	<h2><c:out value="${prod.nome}" /></h2>
	<p><c:out value="${prod.descricao}" /></p>
	<p><c:out value="${prod.valorCompra}" /></p>
	<p><c:out value="${prod.valorVenda}" /></p>
	<p><c:out value="${prod.categorias}" /></p>
	<p><c:out value="${prod.dtCadastro}" /></p>
      </div>
      <hr>
    </c:forEach>
  </body>
</html>
