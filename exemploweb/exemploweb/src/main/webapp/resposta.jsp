<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    
    <h1><c:out value="${novoProd.nome}" /></h1>
    <p><c:out value="${novoProd.descricao}" /></p>
    <p><c:out value="${novoProd.valorCompra}" /></p>
    <p><c:out value="${novoProd.valorVenda}" /></p>
    <p><c:out value="${novoProd.categorias}" /></p>
  </body>
</html>
